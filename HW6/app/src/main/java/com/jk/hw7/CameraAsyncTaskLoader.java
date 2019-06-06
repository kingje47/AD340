package com.jk.hw7;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

/* Class implemented from https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-3-working-in-the-background/lesson-7-background-tasks/7-1-c-asynctask-and-asynctaskloader/7-1-c-asynctask-and-asynctaskloader.html */


public class CameraAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    public CameraAsyncTaskLoader(Context context, String queryString){
        super(context);
        mQueryString = queryString;

    }

    @Nullable
    @Override
    public String loadInBackground() {

        String baseURL = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";

        return NetworkConnection.getData(baseURL, "zoomId", mQueryString, "type", "2");
    }

    @Override
    protected void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }
}
