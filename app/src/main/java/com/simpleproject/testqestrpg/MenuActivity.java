package com.simpleproject.testqestrpg;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.simpleproject.testqestrpg.fonSound.BackgroundMusic;
import com.simpleproject.testqestrpg.fonSound.BirdSound;
import com.simpleproject.testqestrpg.fonSound.NewGameFonMusic;
import com.simpleproject.testqestrpg.fonSound.NewGameFonSound;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        startService(new Intent(this, BackgroundMusic.class));
        startService(new Intent(this, BirdSound.class));

    }

    public void NewGame(View view){
        Intent intent = new Intent(MenuActivity.this,NewGame.class);
        startActivity(intent);
        onDestroy();
    }

    public void Setting(View view){
        Intent intent = new Intent(this,SettingMenu.class);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, BackgroundMusic.class));
        stopService(new Intent(this, BirdSound.class));
    }

    protected void onResume() {
        super.onResume();
        stopService(new Intent(this, NewGameFonMusic.class));
        stopService(new Intent(this, NewGameFonSound.class));
        // The activity has become visible (it is now "resumed").
    }

}
