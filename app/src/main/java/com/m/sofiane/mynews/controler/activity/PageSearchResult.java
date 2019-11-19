package com.m.sofiane.mynews.controler.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.m.sofiane.mynews.R;
import com.m.sofiane.mynews.controler.fragment.tabSearch_fragment;

import butterknife.BindView;

/**
 * created by Sofiane M. 20/06/2019
 */


public class PageSearchResult extends AppCompatActivity {


    @BindView(R.id.RecyclerViewResult)
     RecyclerView rvFragment4;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Fragment mFragment;
        mFragment = new tabSearch_fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.SearchResult, mFragment).commit();

        setContentView(R.layout.activity_page_searchresult);


        setPageTitle();
    }
        private void setPageTitle() {

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Search Articles");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}

