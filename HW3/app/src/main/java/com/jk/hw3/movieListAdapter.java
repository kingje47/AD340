package com.jk.hw3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class movieListAdapter extends ArrayAdapter<Movie> {
    private Context movieContext;
    private int movieResource;

    public movieListAdapter(Context context, int resource, Movie[] objects) {
        super(context, resource, objects);
        movieContext = context;
        movieResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String title = getItem(position).getTitle();
        String year = getItem(position).getYear();

        LayoutInflater inflater = LayoutInflater.from(movieContext);
        convertView = inflater.inflate(movieResource, parent, false);

        TextView TextViewTitle = (TextView) convertView.findViewById(R.id.textview_left);
        TextView TextViewYear = (TextView) convertView.findViewById(R.id.textview_right);

        TextViewTitle.setText(title);
        TextViewYear.setText(year);

        return convertView;
    }


}
