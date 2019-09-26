package com.m.sofiane.mynews;

import com.m.sofiane.mynews.modele.ModeleBase.News;

/**
 * created by Sofiane M. 06/08/2019
 */
public class JSONResponse {


    private News.Articles[] results;

    public JSONResponse(News.Articles[] results) {
        this.results = results;
    }

    public News.Articles[] getResults() {
        return results;
    }

}