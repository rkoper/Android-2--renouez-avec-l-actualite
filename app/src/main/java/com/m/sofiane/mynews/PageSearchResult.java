package com.m.sofiane.mynews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.m.sofiane.mynews.Fragment.tabSearch_fragment;
import com.m.sofiane.mynews.Modele.ModeleSearch.SearchResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

/**
 * created by Sofiane M. 20/06/2019
 */


public class PageSearchResult extends AppCompatActivity {


    @BindView(R.id.RecyclerViewResult)
     RecyclerView rvFragment4;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Fragment mFragment = null;
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

