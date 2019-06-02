package com.jk.hw6;


/* Camera activity implemented from Head First Android Development Chapter 9 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    public static final String CAMERA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_detail);
        CameraFragment cameraFragment = (CameraFragment)
                getSupportFragmentManager().findFragmentById(R.id.camera_recycler);
    }
}
