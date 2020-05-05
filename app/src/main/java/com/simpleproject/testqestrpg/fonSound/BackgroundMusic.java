package com.simpleproject.testqestrpg.fonSound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.simpleproject.testqestrpg.R;


public class BackgroundMusic extends Service {
    //Класс для фоновой музыки

    final String LOG_TAG = "MyService";

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Log.d(LOG_TAG,"onCreate,backgroundMusic");
        player = MediaPlayer.create(this, R.raw.fonmusic1);
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




