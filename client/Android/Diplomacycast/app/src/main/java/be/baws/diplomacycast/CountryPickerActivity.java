package be.baws.diplomacycast;

import android.os.Bundle;
import android.widget.TextView;

import be.baws.diplomacycast.activity.CastHelperActivity;
import be.baws.diplomacycast.domain.Player;
import be.baws.diplomacycast.service.PlayerService;
import be.baws.diplomacycast.service.ServiceRegistry;

/**
 * Created by fbousson on 12/10/14.
 */
public class CountryPickerActivity extends CastHelperActivity {

    PlayerService _playerService;

    @Override
    protected int getMenuToInflate() {
        return R.menu.main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);

        _playerService = ServiceRegistry.getInstance().getPlayerService();
        Player player = _playerService.retrieveLastKnownPlayer();

        TextView playerName = (TextView) findViewById(R.id.country_picker_player_name);
        playerName.setText(player.getName());
    }
}
