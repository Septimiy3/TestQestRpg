package com.simpleproject.testqestrpg;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpleproject.testqestrpg.fonSound.BackgroundMusic;
import com.simpleproject.testqestrpg.fonSound.BirdSound;
import com.simpleproject.testqestrpg.fonSound.NewGameFonMusic;
import com.simpleproject.testqestrpg.fonSound.NewGameFonSound;
import com.simpleproject.testqestrpg.person.Person;


public class NewGame extends Activity {

    String name ;
    int health;
    int damage;
    int money;


    Person person = new Person("Алан",100,5);
    Person person2 = new Person("Риктор",150,3);
    Person person3 = new Person("Рэнэ",70,8);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_activity);

        Intent intent = new Intent(NewGame.this, PartOne.class);

        stopService(new Intent(this, BackgroundMusic.class));
        stopService(new Intent(this, BirdSound.class));
        startService(new Intent(this, NewGameFonMusic.class));
        startService(new Intent(this, NewGameFonSound.class));

        final Button btnOn = findViewById(R.id.button_tavern_music_on);
        final Button btnOff = findViewById(R.id.button_tavern_music_off);
        final Button btnStartPartOne = findViewById(R.id.button_netx_new_game);
        final Button btnChangeOnePerson = findViewById(R.id.first_race);
        final Button btnChangeTwoPerson = findViewById(R.id.second_race);
        final Button btnChangeThreePerson = findViewById(R.id.tree_race);

        btnStartPartOne.setVisibility(View.INVISIBLE);

        btnChangeOnePerson.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_view_new_game);
            textView.setText(R.string.first_race_description);
            btnStartPartOne.setVisibility(View.VISIBLE);
            name = person.getName();
            health = person.getHealth();
            damage = person.getDamage();
            money = person.getMoney();

        });
        btnChangeTwoPerson.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_view_new_game);
            textView.setText(R.string.second_race_description);
            btnStartPartOne.setVisibility(View.VISIBLE);
            name = person2.getName();
            health = person2.getHealth();
            damage = person2.getDamage();
            money = person2.getMoney();
        });
        btnChangeThreePerson.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_view_new_game);
            textView.setText(R.string.tree_race_description);
            btnStartPartOne.setVisibility(View.VISIBLE);
            name = person3.getName();
            health = person3.getHealth();
            damage = person3.getDamage();
            money = person3.getMoney();
        });
        btnOff.setOnClickListener(v -> {
            stopService(new Intent(NewGame.this,NewGameFonMusic.class));
            stopService(new Intent(NewGame.this,NewGameFonSound.class));
        });
        btnOn.setOnClickListener(v -> {
            startService(new Intent(NewGame.this, NewGameFonMusic.class));
            startService(new Intent(NewGame.this, NewGameFonSound.class));
        });
        btnStartPartOne.setOnClickListener(v -> {
            intent.putExtra("PersonName",name);
            intent.putExtra("PersonHealth",health);
            intent.putExtra("PersonDamage",damage);
            intent.putExtra("PersonMoney",money);
            startActivity(intent);
        });


    }


    public void onPause(){
        super.onPause();
    }
    public void onDestroy() {
        super.onDestroy();
    }
    protected void onStop(){
        super.onStop();
    }
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
}
