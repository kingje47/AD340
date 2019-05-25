package com.jk.hw5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Dragon dragon = new Dragon();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        public void onClick(View view) {

        TextView level = (TextView) findViewById(R.id.level);
        Spinner dragonColor = (Spinner) findViewById(R.id.color);
        String color = String.valueOf(dragonColor.getSelectedItem());
        dragon.clicker(findViewById(R.id.checkbox_fire));
        dragon.clicker(findViewById(R.id.checkbox_water));
        dragon.clicker(findViewById(R.id.checkbox_lightning));
        Integer colorInt = dragon.colorLevel(color);
        Integer magicInt = dragon.getMagic();
        Integer dragon_level = colorInt + magicInt;
        String output = getResources().getString(R.string.dragon_level, dragon_level);
        level.setText(output);
        dragon.resetMagic();



    }
}
