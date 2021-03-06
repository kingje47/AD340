package com.jk.hw7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<String>{

    public TextView results;
    private static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        results = findViewById(R.id.results);
    }

    @Override
    public void onClick(View view){

        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {

            results.setText("Waiting...");

            Bundle bundle = new Bundle();
            bundle.putString("queryString", "13");
            getSupportLoaderManager().restartLoader(0, bundle, this);

        } else {
            results.setText(getResources().getString(R.string.no_connection));
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle){
        String queryString = "";
        if (bundle != null){
            queryString = bundle.getString("queryString");
        }
        return new CameraAsyncTaskLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s){
        String fullImageUrl = "";
        String cameraDescription = "";
        Camera[] cameraArray;
        String[] descriptionArray;
        String[] urlArray;
        int[] idArray;
        try {
            JSONObject cameraObject = new JSONObject(s);
            JSONArray features = cameraObject.getJSONArray("Features");
            Log.i(TAG, Integer.toString(features.length()));

            descriptionArray = new String[features.length()];
            urlArray = new String[features.length()];
            idArray = new int[features.length()];
            cameraArray = new Camera[features.length()];


            Integer i = 0;
            while (i < features.length()) {

                JSONObject firstResult = features.getJSONObject(i);
                JSONArray cameras = firstResult.getJSONArray("Cameras");
                for (int j = 0; j < cameras.length(); j++) {
                    JSONObject firstCamera = cameras.getJSONObject(j);
                    cameraDescription = firstCamera.getString("Description");
                    fullImageUrl = firstCamera.getString("ImageUrl");


                    StringBuilder sb = new StringBuilder("http://www.seattle.gov/trafficcams/images/");
                    sb.append(fullImageUrl);
                    fullImageUrl = sb.toString();


                    Camera camera = new Camera(cameraDescription, fullImageUrl, i);
                    descriptionArray[i] = camera.getDescription();
                    urlArray[i] = camera.getCameraUrl();
                    idArray[i] = camera.getCameraId();
                    cameraArray[i] = camera;
                    i++;
                }
            }

//            for (int k = 0; k < idArray.length; k++){
//                Log.i(TAG, Integer.toString(idArray[k]));
//            }
            RecyclerView recyclerView = findViewById(R.id.camera_recycler);

            CameraAdapter adapter = new CameraAdapter(descriptionArray, urlArray, idArray );
            recyclerView.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);


        } catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage());
        }



    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader){

    }
 }
