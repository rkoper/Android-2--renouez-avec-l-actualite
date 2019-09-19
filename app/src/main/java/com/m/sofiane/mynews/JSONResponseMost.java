package com.m.sofiane.mynews;

import com.m.sofiane.mynews.Modele.ModeleBase.News;
import com.m.sofiane.mynews.Modele.ModeleMost.Most;

/**
 * created by Sofiane M. 2019-09-18
 */
public class JSONResponseMost {

    private News.Doc[] results;

    public JSONResponseMost(News.Doc[] results) {
        this.results = results;
    }

    public News.Doc[] getResults1() {
        return results;}
}
