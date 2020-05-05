package com.simpleproject.testqestrpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.simpleproject.testqestrpg.dialogbarmenpartone.DialogBarmenPartOne;
import com.simpleproject.testqestrpg.fonSound.NewGameFonMusic;
import com.simpleproject.testqestrpg.fonSound.NewGameFonSound;
import com.simpleproject.testqestrpg.location.dungeon.DungeonLvlOne;

public class PartOne extends Activity {

    String name;
    int health;
    int damage;
    int money;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_one);

        Intent intent= new Intent(PartOne.this,DialogBarmenPartOne.class);


        name = getIntent().getExtras().getString("PersonName");
        health = getIntent().getExtras().getInt("PersonHealth");
        damage = getIntent().getExtras().getInt("PersonDamage");
        money = getIntent().getExtras().getInt("PersonMoney");


        final Button buttonMusicFonOff = findViewById(R.id.button_tavern_music_off);
        final Button buttonMusicFonOn = findViewById(R.id.button_tavern_music_on);
        final Button btnChangeLocation = findViewById(R.id.btn_change_location);
        final Button btnStatus = findViewById(R.id.button_status);
        final Button btnTalkBarmen = findViewById(R.id.btn_talk_barmen);

        buttonMusicFonOff.setOnClickListener(view -> {
            stopService(new Intent(PartOne.this,NewGameFonMusic.class));
            stopService(new Intent(PartOne.this,NewGameFonSound.class));
        });

        buttonMusicFonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(PartOne.this,NewGameFonMusic.class));
                startService(new Intent(PartOne.this,NewGameFonSound.class));
            }
        });
        btnChangeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogLocation = new AlertDialog.Builder(PartOne.this);
                dialogLocation.setTitle("Пробный вариант нанесения урона")
                                .setMessage(name + " " + "Получает 20 урона");
                health = health - 20;
                dialogLocation.create().show();
            }
        });
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(PartOne.this);
                dialog.setTitle(R.string.status_bar)
                        .setMessage("Имя: " + name + "\n"
                                + "Здоровье: " + health + "\n"
                                + "Урон: " + damage + "\n"
                                + "Деньги: " + money);

                dialog.create().show();
            }
        });
        btnTalkBarmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("PersonName",name);
                intent.putExtra("PersonHealth",health);
                intent.putExtra("PersonDamage",damage);
                startActivity(intent);
            }
        });

    }

    // Мы отдаём текущие значения имя,здоровье,деньги,урон в класс DungeonLvlOne и запускаем активити activity_dungeon_lvl_one
    public void changeLoactionDungeon(View view){
        Intent locDungeon = new Intent(PartOne.this, DungeonLvlOne.class);
        locDungeon.putExtra("PersonName",name);
        locDungeon.putExtra("PersonHealth",health);
        locDungeon.putExtra("PersonDamage",damage);
        locDungeon.putExtra("PersonMoney",money);
        startActivity(locDungeon);
    }


}
