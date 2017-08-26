package net.st4ndard.sampler;

import android.app.Application;

public class MainApplication extends Application {
    private static MainApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static synchronized MainApplication getInstance() {
        return sInstance;
    }
}