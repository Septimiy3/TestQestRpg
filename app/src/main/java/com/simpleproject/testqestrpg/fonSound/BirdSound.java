package com.simpleproject.testqestrpg.fonSound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.simpleproject.testqestrpg.R;

public class BirdSound extends Service {

    final String LOG_TAG = "BirdSound";

    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        Log.d(LOG_TAG,"onCreate,BirdSound");
        player = MediaPlayer.create(this, R.raw.solovey);
        player.setLooping(true);//зацикливание
    }
    @Override
    public void onDestroy() {
        Log.d(LOG_TAG,"onDestroy");
        player.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG,"OnStartCommand");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
