package com.serpanalo.legalaplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.serpanalo.legalaplication.model.Constants;

public class Utils {

    public static void saveToken(String token) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LegalApp.getAppContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.ACCESS_TOKEN, token);
        editor.apply();
    }

    public static String  getToken() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LegalApp.getAppContext());
        return prefs.getString(Constants.ACCESS_TOKEN, null);
    }



    public static void saveStringValue(Context context, String pref_name, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(pref_name, value);
        editor.apply();
    }

    public static String getStringValue(Context context, String pref_name) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(pref_name, "");
    }


    public static void saveBooleanValue(Context context, String pref_name, boolean value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(pref_name, value);
        editor.apply();
    }

    public static boolean getBooleanValue(Context context, String pref_name) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(pref_name, true);
    }

    public static void shareApp() {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Comparte la aplicación con tus compañer@s ");
        LegalApp.getAppContext().startActivity(Intent.createChooser(shareIntent, "Consensum").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

}
