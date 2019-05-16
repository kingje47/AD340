package com.jk.wk_7_inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_get_data);
        button.setOnClickListener(this);

        results = findViewById(R.id.lbl_results);
    }



    @Override
    public void onClick(View view){

        results.setText(getResources().getString(R.string.waiting));

        String url = "https://raw.githubusercontent.com/telpirion/AD340/master/notes/web_content.txt";

        new GitHubAsyncTask(results).execute(url);

    }
}
