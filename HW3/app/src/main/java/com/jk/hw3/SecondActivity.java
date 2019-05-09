package com.jk.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView ListView = (ListView) findViewById(R.id.list_view);

        movieListAdapter adapter = new movieListAdapter(this, R.layout.view_list, Movie.movies);
        ListView.setAdapter(adapter);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(SecondActivity.this, MovieDetail.class);
                intent.putExtra(MovieDetail.EXTRA_MOVIE_ID, position);
                startActivity(intent);

            }
        });

    }


}