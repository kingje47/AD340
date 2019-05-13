package com.jk.hw4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Log: ";
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_home, R.string.nav_about);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragMang = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMang.beginTransaction();
        HomeFrag frag = new HomeFrag();
        fragTrans.add(R.id.fragment_home, frag);
        fragTrans.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.action_settings:
                Log.i(TAG, "Settings clicked");
                Toast toast = makeText(this, "I'm sorry Dave, I'm afraid I can't do that.", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.action_boom:
                Log.i(TAG, "Toast clicked");
                Toast toast_boom = toast_boom = Toast.makeText(this, "BOOM", Toast.LENGTH_LONG);
                toast_boom.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);

                //Code borrowed from: https://stackoverflow.com/questions/5274354/how-can-we-increase-the-font-size-in-toast
                // -->
                ViewGroup group = (ViewGroup)toast_boom.getView();
                TextView messageTextView = (TextView)group.getChildAt(0);
                messageTextView.setTextSize(100);
                // <--
                toast_boom.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment newFrag = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Log.i(TAG, "Nav to home");
                newFrag = new HomeFrag();
                break;

            case R.id.nav_about:
                Log.i(TAG, "Nav to about");
                newFrag = new AboutFrag();
                break;

            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.fragment_home, newFrag);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
        return false;
    }

}
