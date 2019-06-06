//package com.jk.hw6;
//
//import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toolbar;
//
//public class CameraDetailActivity extends AppCompatActivity {
//    public static final String CAMERA_ID = "cameraId";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera_detail);
//
//        int cameraId = (Integer)getIntent().getExtras().get(CAMERA_ID);
//        String cameraName = Camera.cameras[cameraId].getName();
//        TextView textView = (TextView)findViewById(R.id.camera_text);
//        textView.setText(cameraName);
//        int cameraImage = Camera.cameras[cameraId].getImageResourceId();
//        ImageView imageView = (ImageView)findViewById(R.id.camera_image);
//        imageView.setImageDrawable(ContextCompat.getDrawable(this, cameraImage));
//        imageView.setContentDescription(cameraName);
//    }
//}