package be.baws.diplomacycast;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import be.baws.diplomacycast.activity.CastHelperActivity;
import be.baws.diplomacycast.domain.Player;


public class WelcomeActivity extends CastHelperActivity {

    private Button _connectButton;
    private EditText _playerNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        _playerNameEditText = (EditText)  findViewById(R.id.lobby_player_name_edit);
        _connectButton = (Button) findViewById(R.id.lobby_connect_button);

        _connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePlayerName(_playerNameEditText.getText().toString());
            }
        });

    }

    private void validatePlayerName(String playerName) {

        //TODO validation logic.
        if(isValidPlayerName(playerName)){
            Player player = new Player(playerName);
            //TODO add player to chromecast.
            //TODO persist player to preferences.

            startActivity(new Intent(this,LobbyActivity.class ));
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
