package com.jk.test1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private static final String TAG = "TAG two: ";
    public static final String RESULT = "my.response";

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);

        Intent get_second_activity_starter = getIntent();
        String message = get_second_activity_starter.getStringExtra(MainActivity.MESSAGE_ID);

        setContentView(R.layout.activity_second);

        TextView label = (TextView)findViewById(R.id.intent_message);
        label.setText(message);

        Log.i(TAG, "started");
    }

    protected void onClick(View view) {
        EditText textBox = (EditText)findViewById(R.id.response);
        String message = textBox.getText().toString();


        getIntent().putExtra(SecondActivity.RESULT, message);

        setResult(Activity.RESULT_OK, getIntent());
        finish();
    }
}
