package com.m.sofiane.mynews.controler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m.sofiane.mynews.controler.adapter.DataAdapterResult;
import com.m.sofiane.mynews.model.modeleSearch.SearchResult;
import com.m.sofiane.mynews.services.NYTimesService;
import com.m.sofiane.mynews.R;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created by Sofiane M. 2019-09-05
 */
public class TabSearchFragment extends Fragment   {
    private RecyclerView rvFragment;
    private SearchResult rvdata;
    private DataAdapterResult rvAdapter ;
    private final Map<String, String> researchValue = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater mInflater, @Nullable ViewGroup mContainer, @Nullable Bundle savedInstanceState) {
        View view = mInflater.inflate(R.layout.tabsearch_fragment, mContainer, false);

        Intent myintent = getActivity().getIntent();
        String queryTerm = myintent.getStringExtra("q");
        String section = myintent.getStringExtra("fq");
        String beginDate = myintent.getStringExtra("begin_date");
        String endDate = myintent.getStringExtra("end_date");

        if (queryTerm !=null) {
            researchValue.put("q", queryTerm);
        }
        if (section !=null) {
            researchValue.put("fq", section);
        }
        if (beginDate !=null) {
            researchValue.put("begin_date", beginDate);
        }
        if (endDate !=null) {
            researchValue.put("end_date", endDate);
        }

        this.initUI4(view);
        return view;

    }

    private void  initUI4(View view) {

        rvFragment = view.findViewById(R.id.RecyclerViewResult);
        rvFragment.setAdapter(rvAdapter);
        rvFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFragment.setHasFixedSize(true);
        loadJSONResult();

    }

private void loadJSONResult(){
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NYTimesService request = retrofit2.create(NYTimesService.class);
        Call<SearchResult> call2 = request.getJSON4(researchValue);

        call2.enqueue(new Callback<SearchResult>() {
            public void onResponse(@NonNull Call<SearchResult> call, @NonNull Response<SearchResult> response) {
                rvdata= response.body();
                rvAdapter = new DataAdapterResult(rvdata, getContext());
                rvFragment.setAdapter(rvAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<SearchResult> call, @NonNull Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


}