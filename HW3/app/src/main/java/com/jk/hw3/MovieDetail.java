package com.jk.hw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE_ID = "movieID";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        Integer movieID = (Integer)getIntent().getExtras().get(EXTRA_MOVIE_ID);
        String movieTitle = Movie.movies[movieID].getTitle();
        TextView textViewTitle = (TextView) findViewById(R.id.movie_title);
        textViewTitle.setText(movieTitle);

        String movieYear = Movie.movies[movieID].getYear();
        TextView textViewYear = (TextView)findViewById(R.id.movie_year);
        textViewYear.setText(movieYear);

        String movieDirector = Movie.movies[movieID].getDirector();
        TextView textViewDirector = (TextView)findViewById(R.id.movie_director);
        textViewDirector.setText(movieDirector);

        String movieLogline = Movie.movies[movieID].getLogline();
        TextView textViewLogline = (TextView)findViewById(R.id.movie_logline);
        textViewLogline.setText(movieLogline);




    }

}
