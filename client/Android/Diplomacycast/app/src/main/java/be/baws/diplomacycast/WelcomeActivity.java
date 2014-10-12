package be.baws.diplomacycast;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import be.baws.diplomacycast.activity.CastHelperActivity;
import be.baws.diplomacycast.domain.Player;
import be.baws.diplomacycast.service.PlayerService;
import be.baws.diplomacycast.service.ServiceRegistry;


public class WelcomeActivity extends CastHelperActivity {

    private Button _connectButton;
    private EditText _playerNameEditText;


    private PlayerService _playerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        _playerService = ServiceRegistry.getInstance().getPlayerService();


        _playerNameEditText = (EditText)  findViewById(R.id.lobby_player_name_edit);
        _playerNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               _connectButton.setEnabled(s.length() > 0);

            }
        });


        _connectButton = (Button) findViewById(R.id.lobby_connect_button);
        _connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePlayerName(_playerNameEditText.getText().toString());
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Player player = _playerService.retrieveLastKnownPlayer();
        if(player == null){
            _connectButton.setEnabled(false);
        }else{
            _connectButton.setEnabled(true);
            _playerNameEditText.setText(player.getName());
        }
    }

    private void validatePlayerName(String playerName) {

        //TODO validation logic.
        if(isValidPlayerName(playerName)){
            Player player = new Player(playerName);
            _playerService.storePlayer(player);
            _playerService.registerPlayer(player);
            startActivity(new Intent(this, CountryPickerActivity.class));
        }


    }

    private boolean isValidPlayerName(String playerName) {
        return true;
    }

    @Override
    protected int getMenuToInflate() {
       return R.menu.menu_lobbyactivity;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in Andr oidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_hellochromecast) {
            startActivity(new Intent(this, SampleHelloWorld.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
