package com.Reza.leo.models;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.Reza.leo.LoginActivity;
import com.Reza.leo.MainActivity;
import com.Reza.leo.R;

/**
 * Created by User on 25/03/2016.
 */
public class SplashScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
/** set time to splash out */
        final int welcomeScreenDisplay = 3000;
/** create a thread to show splash up to splash time */
        Thread welcomeThread = new Thread() {

            int wait = 0;

            @Override
            public void run() {
                try {
                    super.run();
/**
 * use while to get the splash time. Use sleep() to increase
 * the wait variable for every 100L.
 */
                    while (wait < welcomeScreenDisplay) {
                        sleep(200);
                        wait += 200;
                    }
                } catch (Exception e) {
                    System.out.println("EXc=" + e);
                } finally {
/**
 * Called after splash times up. Do some action after splash
 * times up. Here we moved to another main activity class
 */
                    startActivity(new Intent(SplashScreen.this,
                            LoginActivity.class));
                    finish();
                }
            }
        };
        welcomeThread.start();

    }}
