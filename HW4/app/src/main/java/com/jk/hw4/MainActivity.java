package com.jk.hw4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFrag.OnNextClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragMang = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMang.beginTransaction();
        HomeFrag frag = new HomeFrag();
        fragTrans.commit();
    }

    public void swapFrags(Fragment frag){
        Fragment newFrag = null;
        if (frag instanceof HomeFrag){
            newFrag = new AboutFrag();
        }else{
            newFrag = new HomeFrag();
        }

        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.fragment_home, newFrag);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
    }
}
