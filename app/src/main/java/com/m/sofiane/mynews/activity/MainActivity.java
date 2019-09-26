package com.m.sofiane.mynews.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.m.sofiane.mynews.PageSearch;
import com.m.sofiane.mynews.R;
import com.m.sofiane.mynews.SectionPagerAdapter;


public class MainActivity extends AppCompatActivity
       implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mdrawerlayout ;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


        TabLayout tabLayout = findViewById(R.id.tab_layout);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final ViewPager viewPager = findViewById(R.id.pager);
        PagerAdapter SectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(SectionPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setupWithViewPager(viewPager);

        this.configureToolBar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    private void configureToolBar() {
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout mdrawerlayout = (findViewById(R.id.drawer_layout));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mdrawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mdrawerlayout.addDrawerListener(toggle);

        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mdrawerlayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_activity_search:
                Intent Page_Search = new Intent(MainActivity.this, PageSearch.class);
                startActivity(Page_Search);
                break;
            case R.id.About:
                Intent Page_About = new Intent(MainActivity.this, PageAbout.class);
                startActivity(Page_About);
                break;
            case R.id.notification:
                Intent Page_Notif = new Intent(MainActivity.this,PageNotification.class);
                startActivity(Page_Notif);
                break;
            case R.id.help:
                Intent Page_help = new Intent(MainActivity.this, PageHelp.class);
                startActivity(Page_help);
                break;

            default:
                return super.onOptionsItemSelected(item);


        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent Page_Search = new Intent(MainActivity.this, PageSearch.class);
            startActivity(Page_Search);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        return true;

    }

}




