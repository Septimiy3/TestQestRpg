package com.simpleproject.testqestrpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.simpleproject.testqestrpg.fonSound.BackgroundMusic;
import com.simpleproject.testqestrpg.fonSound.BirdSound;

public class BackstoryActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backstory_activity);
        TextView textView1 = findViewById(R.id.text_backstory);

        textView1.setText(R.string.backstory2);

    }

    public void clickTextView(View view){
        TextView textView2 = findViewById(R.id.text_backstory);
        textView2.setText(R.string.backstory);
    }

    public void clickNextBackstoryButton(View view){
        Intent intent = new Intent(BackstoryActivity.this,MenuActivity.class);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, BackgroundMusic.class));
        stopService(new Intent(this, BirdSound.class));
    }


}
