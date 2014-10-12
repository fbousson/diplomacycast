package be.baws.diplomacycast;

import android.os.Bundle;

import be.baws.diplomacycast.activity.CastHelperActivity;

/**
 * Created by fbousson on 12/10/14.
 */
public class LobbyActivity extends CastHelperActivity {
    @Override
    protected int getMenuToInflate() {
        return R.menu.main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
    }
}
