package com.m.sofiane.mynews.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.m.sofiane.mynews.R;

public class PageHelp extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_help);

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Help");



        this.configureToolBar();

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent BackInBack = new Intent(this, MainActivity.class);
                startActivity(BackInBack);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.activity_page_toolbar, menu);
        return true;
    }

    private void configureToolBar(){
        Toolbar toolbar= findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);
    }

}