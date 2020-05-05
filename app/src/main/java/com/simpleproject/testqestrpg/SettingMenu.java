package com.simpleproject.testqestrpg;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.simpleproject.testqestrpg.fonSound.BackgroundMusic;


public class SettingMenu extends Activity  {

    Button buttonOn;

    Button buttonOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_menu);
        buttonOff = findViewById(R.id.button_off);
        buttonOn = findViewById(R.id.button_on);

        buttonOff.setVisibility(View.GONE);


    }

    public void buttonSoundOn(View view){
        stopService(new Intent(this, BackgroundMusic.class));
        buttonOn.setVisibility(View.INVISIBLE);
        buttonOff.setVisibility(View.VISIBLE);
    }

    public void buttonSoundOff(View view){
        startService(new Intent(this, BackgroundMusic.class));
        buttonOn.setVisibility(View.VISIBLE);
        buttonOff.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
