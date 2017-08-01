package com.example.anureet.menutest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.anureet.menutest.R.id.Vp;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //DbHelper mydb;
    public static final String TAG =" menu";
    ViewPager vp;
    Button btncp;
    TabLayout tbl;
    ViewPagerAdapter vpa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        vp = (ViewPager)findViewById(R.id.Vp);
//        vp.setAdapter(new PagesActivity.SectionsPagerAdapter(getSupportFragmentManager() ));

        //mydb = new DbHelper(this);

       // btncp = (Button)findViewById(R.id.btncp);
//        btncp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            startActivity(new Intent(MainActivity.this , PagesActivity.class));
//            }
//        });

        tbl = (TabLayout)findViewById(R.id.Tbl);
        tbl.setupWithViewPager(vp);
       // tbl.setTabsFromPagerAdapter(vpa);

        vp = (ViewPager)findViewById(R.id.Vp);
        setupWithViewPager(vp);
        tbl.setOnTabSelectedListener(onTabSelectedListener(vp));
       // tbl1 = (TabLayout)findViewById(R.id.Tbl1);
       // tbl1.setupWithViewPager(vp);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private TabLayout.OnTabSelectedListener onTabSelectedListener(ViewPager vp) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

    private void setupWithViewPager(ViewPager vp) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstFrag() , "Payment");
        adapter.addFragment(new Debts() , "debts");
        adapter.addFragment(new Notes() , "Notes");


        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tbl));
        onTabSelectedListener(vp);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Collective) {
            Log.d(TAG, "onNavigationItemSelected: ");
          Intent i = new Intent(MainActivity.this , Collective.class);
            startActivity(i);

        } else if (id == R.id.nav_Monthly) {

        } else if (id == R.id.nav_Personal) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
