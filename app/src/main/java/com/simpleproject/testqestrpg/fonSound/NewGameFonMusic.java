package com.simpleproject.testqestrpg.fonSound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.simpleproject.testqestrpg.R;

public class NewGameFonMusic extends Service {

    MediaPlayer player;

    final String LOG_TAG = "NewGameServiceFonMusic";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG,"OnStartCommand");
        player.start();
        player.setLooping(true);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate(){
        Log.d(LOG_TAG,"OnCreateNewGameFonMusic");
        player = MediaPlayer.create(this, R.raw.newgameactivity);
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG,"onDestroy");
        player.stop();
        super.onDestroy();
    }


}
