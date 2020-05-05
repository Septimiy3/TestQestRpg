package com.simpleproject.testqestrpg.fonSound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.simpleproject.testqestrpg.R;

public class NewGameFonSound extends Service {

    MediaPlayer player;
    final String LOG_TAG = "NewGameFonSoundService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        Log.d(LOG_TAG,"NewGameFonSoundOnCreate");
        player = MediaPlayer.create(this,R.raw.bonfire);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG,"OnStartCommand");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
