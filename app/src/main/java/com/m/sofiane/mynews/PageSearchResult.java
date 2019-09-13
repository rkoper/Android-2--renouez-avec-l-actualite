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
    public DataAdapterResult rvAdapter4;
    private List<SearchResult> rvdata4;
    private RequestQueue mRequestQueue;


    @BindView(R.id.RecyclerViewResult)
     RecyclerView rvFragment4;

    protected CompositeDisposable disposable = new CompositeDisposable();
    Map<String, String> queryData = new HashMap<>();
    private String mBeginDate;
    private String mEndDate;
    private String mQueryTerm;
    private String mSection;
    private Fragment mFragment;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Fragment mFragment = null;
        mFragment = new tabSearch_fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.SearchResult, mFragment).commit();

        setContentView(R.layout.activity_page_searchresult);

        Intent myintent = getIntent();
        mQueryTerm = myintent.getStringExtra("q");
        mSection= myintent.getStringExtra("fq");
        mBeginDate = myintent.getStringExtra("begin_date");
        mEndDate = myintent.getStringExtra("end_date");

      //  mRequestQueue = Volley.newRequestQueue(this);
       // loadJSON4();
        setPageTitle();
        getSettingsURL();

    }
  /**  private void loadJSON4() {
        String url = "https://api.nytimes.com/svc/articlesearch.json?api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("response");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject respons = jsonArray.getJSONObject(i);
                        String createTitle = respons.getString("title");
                        String createShortUrl = respons.getString("shorturl");

                        rvdata4.add(new SearchResult(createShortUrl, createTitle));
                    }

                    rvAdapter4 = new DataAdapterResult(rvdata4, PageSearchResult.this);
                    rvFragment4.setAdapter(rvAdapter4);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

        });

        mRequestQueue.add(request);
    }
**/
        private void setPageTitle() {

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Search Articles");
    }

    private void getSettingsURL(){
        mBeginDate = getIntent().getStringExtra("beginDate");
        mEndDate = getIntent().getStringExtra("endDate");
        mQueryTerm = getIntent().getStringExtra("queryTerm");
        mSection = getIntent().getStringExtra("sectionChecked");

        if (mBeginDate != null){
            queryData.put("begin_date", mBeginDate);
        }
        if (mEndDate != null){
            queryData.put("end_date", mEndDate);
        }
        queryData.put("q", mQueryTerm);
        queryData.put("fq", mSection);
    }
}

