package com.jk.wk_7_inclass;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GitHubAsyncTask extends AsyncTask<String, Void, String> {

    private WeakReference<TextView> mTextView;

    public GitHubAsyncTask(TextView textView){
        this.mTextView = new WeakReference<>(textView);
    }

    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String results = "";

        try{

            URL requestURL = new URL(strings[0]);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream  = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

            results = builder.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return results;
    }

    @Override
    protected void onPostExecute(String s){
        mTextView.get().setText(s);
    }
}
