package com.jk.hw5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Dragon dragon = new Dragon(null, null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


        public void onClick(View view) {
            EditText mEdit = findViewById(R.id.magic_text_box);
            TextView level = (TextView) findViewById(R.id.level);
            Spinner dragonColor = (Spinner) findViewById(R.id.color);
            String color = String.valueOf(dragonColor.getSelectedItem());
            boolean stringCheck;

            String magic = mEdit.getText().toString();
            Integer colorInt = dragon.colorLevel(color);
            Integer magicInt = dragon.magicLevel(magic);
            stringCheck = stringChecker(magic);
            if (stringCheck) {
                Integer dragon_level = colorInt + magicInt;
                String output = getResources().getString(R.string.dragon_level, dragon_level);
                level.setText(output);
            } else {
                String error = getText(R.string.error).toString();
                level.setText(error);
            }


    }

    public boolean stringChecker(String input) {

//        check to see if the input string is exactly one of the three options, if not return false
        if ((input.toLowerCase().matches("fire"))||
                (input.toLowerCase().matches("lightning"))||
                        (input.toLowerCase().matches("water"))){
                    return true;
        } else {
                    return false;
        }
    }

}
