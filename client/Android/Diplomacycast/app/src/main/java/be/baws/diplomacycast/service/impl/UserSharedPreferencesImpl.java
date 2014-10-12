package be.baws.diplomacycast.service.impl;

import android.content.Context;
import android.content.SharedPreferences;

import be.baws.diplomacycast.service.UserSharedPreferences;

/**
 * Created by fbousson on 12/10/14.
 */
public class UserSharedPreferencesImpl implements UserSharedPreferences {


    private static final String PREFS_NAME = "UserPreferencesFile";

    private static final String ENTRY_PLAYER = "player";


    private static SharedPreferences userSharedPreferences;
    private static SharedPreferences.Editor editor;

    public UserSharedPreferencesImpl(Context applicationContext) {
        userSharedPreferences = applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = userSharedPreferences.edit();
    }

    public String getPlayer()
    {
        return userSharedPreferences.getString(ENTRY_PLAYER, null);
    }

    public void setPlayer(final String player)
    {
        editor.putString(ENTRY_PLAYER, player);
        editor.commit();
    }

}
