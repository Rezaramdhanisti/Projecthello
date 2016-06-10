package com.Reza.leo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


import com.Reza.leo.models.TransactionPage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;

    private Fragment Misc;
    private List<String> navHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar_title_home);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//       * POPUP DISINI
//        pindahpopup = (Button) findViewById(R.id.buttonclose);
//        pindahpopup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent_obj = new Intent(MainActivity.this, Popupactivity.class);
//                startActivity(intent_obj);
//
//            }
//        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        Intent loggedIn = getIntent();


            //Home Page
            setupFragmentControlRoom();
        }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (navHistory != null && navHistory.size()>=2){
            int count = navHistory.size();
            String title = navHistory.get(count-2);
            navHistory.remove(count-1);
            navHistory.remove(count-2);

            if (title.contains(getString(R.string.toolbar_title_home))) {
                setupFragmentControlRoom();
            }
            else{
                super.onBackPressed();
            }
        }
        else if(Misc != null && !(Misc instanceof FragmentControlRoom)){
            setupFragmentControlRoom();
        }
        else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            setupFragmentUser();
//            setupFragmentPengaturan();
//        }
//        return true;
//    }
//

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_main_home) {
            setupFragmentControlRoom();
        }
        else if (id == R.id.nav_main_percobaan) {
            setupHomePage();
        }
        else if (id == R.id.nav_main_transcation) {
            setupTransactionPage();
        }
        else if (id == R.id.nav_main_recycle) {
            recyclebro();
        }
        else if(id == R.id.nav_user_logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * User Logout
     **/
    private void logout()   {
        //Back to login
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
    private void recyclebro()   {

        Intent recycle = new Intent(this, DemoRecycleActivity.class);
        startActivity(recycle);
    }

    private void setupFragMainAfterFiltering(Fragment fragToShow){

        Log.d(LoginActivity.TAG, "Attaching Fragment...");
        String title = fragToShow.getArguments().getString("title");
        toolbar.setTitle(title);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_item_detail_container, fragToShow)
                .commit();
        Log.d(LoginActivity.TAG, "Attached Fragment");

        }


    public void setupHomePage() {
        if (Misc == null || !(Misc instanceof HomePage)) {
            Misc = HomePage.newInstance(getString(R.string.toolbar_title_payment));
        }
        setupFragMainAfterFiltering(Misc);
    }
    public void setupTransactionPage() {
        if (Misc == null || !(Misc instanceof TransactionPage)) {
            Misc = TransactionPage.newInstance(getString(R.string.toolbar_title_transaks));
        }
        setupFragMainAfterFiltering(Misc);
    }


    public void setupFragmentControlRoom() {
        if (Misc == null || !(Misc instanceof FragmentControlRoom)) {
            Misc = FragmentControlRoom.newInstance(getString(R.string.toolbar_title_home));
        }

        navHistory = new ArrayList<String>();
        setupFragMainAfterFiltering(Misc);
    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LoginActivity.TAG, "dondon activity onStart");
        // The activity is about to become visible.
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LoginActivity.TAG, "dondon activity onPause");
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LoginActivity.TAG, "dondon activity onStop");
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LoginActivity.TAG, "dondon activity onDestroy");
        // The activity is about to be destroyed.
    }



}
