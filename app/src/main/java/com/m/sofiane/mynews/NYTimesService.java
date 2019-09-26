package com.m.sofiane.mynews;

import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * created by Sofiane M. 06/08/2019
 */
public interface NYTimesService {

    @GET("topstories/v2/home.json?api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm")
    Call<JSONResponse> getJSON();

  //  @GET("topstories/v2/home.json?api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm")
   @GET("mostpopular/v2/viewed/7.json?api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm")
    Call<JSONResponse> getJSON2();

    @GET("topstories/v2/sports.json?api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm")
    Call<JSONResponse> getJSON3();

    @GET("search/v2/articlesearch.json?&api-key=327RyaQp2UwU2bq5qUZQIsVVsBqCmJhm")
    Call<SearchResult> getJSON4(@QueryMap Map<String, String> researchValue);

}
