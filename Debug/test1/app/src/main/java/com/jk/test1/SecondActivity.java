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

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_ID);

        setContentView(R.layout.activity_second);

        TextView label = (TextView)findViewById(R.id.intent_message);
        label.setText(message);

        Log.i(TAG, "started");
    }

    protected void onClick(View view) {
        EditText textBox = (EditText)findViewById(R.id.response);
        String message = textBox.getText().toString();

        Intent responseIntent = new Intent();
        responseIntent.putExtra(SecondActivity.RESULT, message);

        setResult(Activity.RESULT_OK, responseIntent);
        finish();
    }
}
