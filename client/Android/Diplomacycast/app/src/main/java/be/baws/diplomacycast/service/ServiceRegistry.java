package be.baws.diplomacycast.service;

import android.content.Context;

import be.baws.diplomacycast.service.impl.PlayerServiceImpl;
import be.baws.diplomacycast.service.impl.UserSharedPreferencesImpl;

/**
 * Created by fbousson on 12/10/14.
 */
public class ServiceRegistry {


    private static ServiceRegistry g_instance;

    private UserSharedPreferences _userSharedPreferences;
    private PlayerService _playerService;



    public static ServiceRegistry getInstance(){
        if(g_instance == null){
           throw new IllegalStateException("Service registery not initialized");
        }

        return g_instance;
    }

    private ServiceRegistry(Context applicationContext) {

        _userSharedPreferences = new UserSharedPreferencesImpl(applicationContext);
        _playerService = new PlayerServiceImpl(_userSharedPreferences);



    }

    public static void initialize(Context applicationContext) {
        g_instance = new ServiceRegistry(applicationContext);
    }





}
