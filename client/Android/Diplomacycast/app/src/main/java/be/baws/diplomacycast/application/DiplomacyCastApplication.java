package be.baws.diplomacycast.application;

import android.app.Application;

import be.baws.diplomacycast.service.ServiceRegistry;

/**
 * Created by fbousson on 12/10/14.
 */
public class DiplomacyCastApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceRegistry.initialize(this);
    }
}
