package com.jk.appfragtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class HostActivity extends AppCompatActivity
        implements MainFragment.OnNextClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.fragment_host, fragment);
        fragmentTransaction.commit();
    }

    public void swapFragments(Fragment fragment) {
        Fragment newFragment = null;

        if (fragment instanceof MainFragment) {
            newFragment = new SecondFragment();
        } else {
            newFragment = new MainFragment();
        }

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_host, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void OnMainFragmentNextClick(MainFragment fragment) {
        swapFragments(fragment);
    }


}