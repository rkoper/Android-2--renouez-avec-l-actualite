package com.m.sofiane.mynews.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;


import com.m.sofiane.mynews.Modele.ModeleBase.News;
import com.m.sofiane.mynews.R;

import java.util.List;

/**
 * created by Sofiane M. 2019-08-21
 */

public class SubActivity extends AppCompatActivity {
    private List<News.Articles> rvdata1;
    private WebView webView;
    private String url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        url = getIntent().getStringExtra("url")  ;


        webView = findViewById(R.id.text_view_result);
        webView.loadUrl(url);

        setPageTitle();

    }
    private void setPageTitle(){

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Articles");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}