package com.m.sofiane.mynews.fragment;

/**
 * created by Sofiane M. 20/06/2019
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m.sofiane.mynews.DataAdapterMost;
import com.m.sofiane.mynews.JSONResponse;
import com.m.sofiane.mynews.modele.ModeleBase.News;
import com.m.sofiane.mynews.NYTimesService;
import com.m.sofiane.mynews.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class tab2_fragment  extends Fragment {
    private RecyclerView rvFragment;
    private List<News.Articles> rvData;
    public DataAdapterMost rvAdapter ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater mInflater, @Nullable ViewGroup mContainer, @Nullable Bundle savedInstanceState) {

        View view1 = mInflater.inflate(R.layout.tab2_fragment, mContainer, false);

        this.initUI2(view1);
        return view1;

    }


    private void  initUI2(View view) {
        this.rvData = new ArrayList<>();
        this.rvAdapter = new DataAdapterMost(this.rvData, getContext());
        rvFragment = view.findViewById(R.id.RecyclerViewTwo);
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
        Call<JSONResponse> call = request.getJSON2();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                rvData = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));
                rvAdapter = new DataAdapterMost(rvData, getContext());
                rvFragment.setAdapter(rvAdapter);


            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }

}