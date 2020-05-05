package com.simpleproject.testqestrpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


import androidx.annotation.Nullable;

import com.simpleproject.testqestrpg.fonSound.BackgroundMusic;
import com.simpleproject.testqestrpg.fonSound.BirdSound;

public class WelcomActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcom_activity);
        backstory();
        startService(new Intent(this, BackgroundMusic.class));
        startService(new Intent(this, BirdSound.class));
    }


    private void backstory(){
        final Intent intent = new Intent(this,BackstoryActivity.class);

        int interval = 5000; // 5 sec

        Date timeToRun = new Date(System.currentTimeMillis() + interval);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {

                // Task here ...
                startActivity(intent);
            }
        }, timeToRun);

    }

    public void onPause(){
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,BackgroundMusic.class));
    }

}
