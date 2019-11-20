package com.m.sofiane.mynews.controler.fragment;


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

import com.m.sofiane.mynews.controler.adapter.DataAdapter;
import com.m.sofiane.mynews.model.JSONResponse;
import com.m.sofiane.mynews.model.modeleBase.News;
import com.m.sofiane.mynews.services.NYTimesService;
import com.m.sofiane.mynews.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class tab1_fragment  extends Fragment   {
    private RecyclerView rvFragment;
    private List<News.Articles> rvdata;
    private DataAdapter rvAdapter ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater mInflater, @Nullable ViewGroup mContainer, @Nullable Bundle savedInstanceState) {
        View view = mInflater.inflate(R.layout.tab1_fragment, mContainer, false);

        this.initUI(view);
        return view;

    }

    private void  initUI(View view) {
        this.rvdata = new ArrayList<>();
        this.rvAdapter = new DataAdapter(this.rvdata, getContext());
        rvFragment = view.findViewById(R.id.RecyclerViewOne);
        rvFragment.setAdapter(rvAdapter);
        rvFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFragment.setHasFixedSize(true);
        loadJSON();

    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        final NYTimesService request = retrofit.create(NYTimesService.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            public void onResponse(@NonNull Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                rvdata= Arrays.asList(jsonResponse.getResults());
                rvAdapter = new DataAdapter(rvdata,getContext());
                rvFragment.setAdapter(rvAdapter);


            }

            @Override
            public void onFailure(@NonNull Call<JSONResponse> call, @NonNull Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}