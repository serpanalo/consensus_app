package com.serpanalo.legalaplication;

import android.app.Application;
import android.content.Context;

import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;

public class LegalApp extends Application {

    private static Context context;
    private static LegalApp mInstance;

    public void onCreate() {
        super.onCreate();

        LegalApp.context = getApplicationContext();
        mInstance = this;
        RxJavaPlugins.setErrorHandler(Functions.<Throwable>emptyConsumer());
    }

    public static Context getAppContext() {
        return LegalApp.context;
    }

}
