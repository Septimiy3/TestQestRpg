package com.simpleproject.testqestrpg.dialogbarmenpartone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpleproject.testqestrpg.PartOne;
import com.simpleproject.testqestrpg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogBarmenPartOne extends Activity {


    String name;
    int health;
    int damage;

    Button btnDialogV1;
    Button btnDialogV2;
    Button btnDialogV3;

    TextView dialogBarmen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_barmen_activity);

        name = getIntent().getExtras().getString("PersonName");
        health = getIntent().getExtras().getInt("PersonHealth");
        damage = getIntent().getExtras().getInt("PersonDamage");

        dialogBarmen = findViewById(R.id.text_view_dialog_barmen);

        Intent intent= new Intent(DialogBarmenPartOne.this,PartOne.class);

        btnDialogV1 = findViewById(R.id.button_dialog_barmen_1);
        btnDialogV2 = findViewById(R.id.button_dialog_barmen_2);
        btnDialogV3 = findViewById(R.id.button_dialog_barmen_3);
        setText();

        btnDialogV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBarmen.setText(R.string.v3_otvet);
                health = health + 15;
                intent.putExtra("PersonName",name);
                intent.putExtra("PersonHealth",health);
                intent.putExtra("PersonDamage",damage);
                btnDialogV1.setText(R.string.thanks);
                btnDialogV2.setVisibility(View.INVISIBLE);
                btnDialogV3.setVisibility(View.INVISIBLE);

            }
        });
        btnDialogV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                onDestroy();
            }
        });

    }
    public void setHealth(){

    }

    public void setText(){
        if(name.equals("Алан")){
            dialogBarmen.setText(R.string.talk_barmen_1);
        }if(name.equals("Риктор")){
            dialogBarmen.setText(R.string.talk_barmen_2);
        }if (name.equals("Рэнэ")){
            dialogBarmen.setText(R.string.talk_barmen_3);
        }
    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
}
