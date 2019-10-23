package com.m.sofiane.mynews;

import com.m.sofiane.mynews.modele.ModeleBase.News;
import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * created by Sofiane M. 19/09/2019
 */
public class newsArticles {

    private News.Articles mArticles;

    @Before
    public void init(){
        mArticles = new News.Articles();
    }

    @Test
    public void getSection(){
        String section = "World";

        mArticles.setSection(section);

        assertEquals("World", mArticles.getSection());
    }

    @Test
    public void getSubsection() {
        String subSection = "U.S.";

        mArticles.setSubsection(subSection);

        assertEquals("U.S.", mArticles.getSubsection());

    }
        @Test
        public void getPublishedDate(){
            String date  = "09/10/2019";

            mArticles.setPublishedDate(date);

            assertEquals("09/10/2019", mArticles.getPublishedDate());
    }

    @Test
    public void getTitle(){
        String title  = "Top 10 Crazy Donald Trump Moments";

        mArticles.setTitle(title);

        assertEquals("Top 10 Crazy Donald Trump Moments", mArticles.getTitle());
    }



}
