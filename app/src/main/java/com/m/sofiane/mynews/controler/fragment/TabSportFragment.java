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
import com.m.sofiane.mynews.R;
import com.m.sofiane.mynews.services.NYTimesService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TabSportFragment extends Fragment {
    private RecyclerView rvFragment;
    private List<News.Articles> rvData;
    private DataAdapter rvAdapter ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater mInflater, @Nullable ViewGroup mContainer, @Nullable Bundle savedInstanceState) {

        View view = mInflater.inflate(R.layout.tab3_fragment, mContainer, false);

        this.initUI3(view);

        return view;

    }


    private void  initUI3(View view) {
        this.rvData = new ArrayList<>();

        this.rvAdapter = new DataAdapter(this.rvData, getContext());
        rvFragment = view.findViewById(R.id.RecyclerViewThree);
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

        NYTimesService request = retrofit.create(NYTimesService.class);
        Call<JSONResponse> call = request.getJSON3();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(@NonNull Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                rvData = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));
                rvAdapter = new DataAdapter(rvData, getContext());
                rvFragment.setAdapter(rvAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<JSONResponse> call, @NonNull Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }

}