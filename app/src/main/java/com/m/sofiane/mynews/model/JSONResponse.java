package com.m.sofiane.mynews.model;

import com.m.sofiane.mynews.model.modeleBase.News;

/**
 * created by Sofiane M. 06/08/2019
 */
public class JSONResponse {


    private final News.Articles[] results;

    public JSONResponse(News.Articles[] results) {
        this.results = results;
    }

    public News.Articles[] getResults() {
        return results;
    }

}