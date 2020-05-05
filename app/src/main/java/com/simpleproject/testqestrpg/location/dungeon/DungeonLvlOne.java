package com.simpleproject.testqestrpg.location.dungeon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpleproject.testqestrpg.NewGame;
import com.simpleproject.testqestrpg.PartOne;
import com.simpleproject.testqestrpg.R;
import com.simpleproject.testqestrpg.person.Monster;

public class DungeonLvlOne extends Activity implements View.OnClickListener {

    String name;
    int health;
    int damage;
    int money;

    String nameSkeleton;
    int healthSkeleton;
    int damageSkeleton;
    int moneySkeleton;

    TextView textDungeon;

    Button btnDialogDungeon1;
    Button btnDialogDungeon2;
    Button btnDialogDungeon3;
    Button btnDungeonStatus;


    Monster skeletonUncommon = new Monster("Скелет",25,2,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_lvl_one);

        name = getIntent().getExtras().getString("PersonName");
        health = getIntent().getExtras().getInt("PersonHealth");
        damage = getIntent().getExtras().getInt("PersonDamage");
        money = getIntent().getExtras().getInt("PersonMoney");

        nameSkeleton = skeletonUncommon.getName();
        healthSkeleton = skeletonUncommon.getHealth();
        damageSkeleton = skeletonUncommon.getDamage();
        moneySkeleton = skeletonUncommon.getMoney();

        textDungeon = findViewById(R.id.text_view_dungeon);
        textDungeon.setText("Это пробный бой со скелетом");

        btnDialogDungeon1 = findViewById(R.id.button_dialog_dungeon_1);
        btnDialogDungeon2 = findViewById(R.id.button_dialog_dungeon_2);
        btnDialogDungeon3 = findViewById(R.id.button_dialog_dungeon_3);
        btnDungeonStatus = findViewById(R.id.button_dialog_dungeon_status);

        btnDialogDungeon1.setText("убежать");
        btnDialogDungeon2.setText("Атаковать");
        btnDialogDungeon3.setText("Поговорить");

        btnDialogDungeon1.setOnClickListener(this);
        btnDialogDungeon2.setOnClickListener(this);
        btnDialogDungeon3.setOnClickListener(this);
        btnDungeonStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DungeonLvlOne.this, PartOne.class);
        switch (v.getId()){
            case R.id.button_dialog_dungeon_1:
                intent.putExtra("PersonName",name);
                intent.putExtra("PersonHealth",health);
                intent.putExtra("PersonDamage",damage);
                intent.putExtra("PersonMoney",money);
                startActivity(intent);
                break;
            case R.id.button_dialog_dungeon_status:
                AlertDialog.Builder dialog = new AlertDialog.Builder(DungeonLvlOne.this);
                dialog.setTitle(R.string.status_bar)
                        .setMessage("Имя: " + name + "\n"
                                + "Здоровье: " + health + "\n"
                                + "Урон: " + damage + "\n"
                                + "Деньги: " + money);
                dialog.create().show();
                break;
            case R.id.button_dialog_dungeon_2:
                textDungeon.setText("Вы нанесли " + damage + " " + "урона" + "\n"
                                    +"получили " + damageSkeleton + " урона от Скелета"+ "\n"
                                    + "Здоровье скелета осталось " + healthSkeleton);
                healthSkeleton = healthSkeleton - damage;
                health = health - damageSkeleton;
                if (healthSkeleton<0){
                    textDungeon.setText("Поздравляю вы убили самого самого обычного скелета");
                    btnDialogDungeon1.setVisibility(View.INVISIBLE);
                    btnDialogDungeon2.setVisibility(View.INVISIBLE);
                    btnDialogDungeon3.setText("Уйти в таверну");
                }
                intent.putExtra("PersonName",name);
                intent.putExtra("PersonHealth",health);
                intent.putExtra("PersonDamage",damage);
                intent.putExtra("PersonMoney",money);
                break;
            case R.id.button_dialog_dungeon_3:

                // Передаём данные персонажа в PartOne и запускаем локацию таверны
                if (btnDialogDungeon3.getText().equals("Уйти в таверну")){
                    intent.putExtra("PersonName",name);
                    intent.putExtra("PersonHealth",health);
                    intent.putExtra("PersonDamage",damage);
                    intent.putExtra("PersonMoney",money);
                    startActivity(intent);
                }else if ( btnDialogDungeon3.getText().equals("Поговорить")){
                    textDungeon.setText("Вы серьёзно?,перед вами стоит старая и вонючая куча костей а вы зотите с ней поговорить?" +
                            "Вы говорите скелету 'привет',на что он ударяет вас мечом по ноге,вы успеваете отпрыгнуть но при этом скелет задевает вас мечом" +
                            " " + "получите 1 урон");
                    health = health-1;
            }
                break;
        }
    }
}
