package com.serpanalo.legalaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.serpanalo.legalaplication.model.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // getSupportActionBar().hide();
        startTimer();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startInitialActivity();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, Constants.DELAY_TIME);
    }

    private void startInitialActivity() {

        if (isFirstAccessing())
            openOnboarder();
        else {
            openDispatchActivity();
        }
    }

    private boolean isFirstAccessing() {

        return Utils.getBooleanValue(this, Constants.FIRST_TIME);

    }

    private void openOnboarder() {
        Intent intent = new Intent(this, OnboardingActivity.class);
        startActivity(intent);
        finish();
    }

    private void openDispatchActivity() {
        Intent intent = new Intent(this, DispatchActivity.class);
        startActivity(intent);
        finish();
    }
}
