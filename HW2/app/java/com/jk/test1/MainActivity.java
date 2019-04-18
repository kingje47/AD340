package com.jk.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG one: ";
    private static final int RESULT_ID = 1;

    public static final String MESSAGE_ID = "my.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    protected void onClick(View button){
        Log.i(TAG, "Button" + button.getId() + " clicked.");

        EditText textbox = (EditText)findViewById(R.id.message_box);
        String message = textbox.getText().toString();

        Intent second_activity_starter = new Intent (this, SecondActivity.class);
        second_activity_starter.putExtra(MESSAGE_ID, message);

        startActivity(second_activity_starter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_ID) {
            if (resultCode == RESULT_OK) {
                TextView label = (TextView)findViewById(R.id.message);
                String message = label.getText().toString();
                message += "\n\n" + data.getStringExtra(SecondActivity.RESULT);
                label.setText(message);
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "life begins");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "life continues");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "life ends");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "universe implodes");
    }
}


