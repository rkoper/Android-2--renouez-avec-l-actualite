package com.m.sofiane.mynews;

import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class searchResultDocTest {

    private SearchResult.Doc mDoc;

    @Before
    public void init(){
        mDoc = new SearchResult.Doc();
    }

    @Test
    public void getWebUrl(){
        String url = "https://www.nytimes.com/";

        mDoc.setWebUrl(url);

        assertEquals("https://www.nytimes.com/", mDoc.getWebUrl());
    }

    @Test
    public void getAbstract(){
        String title = "Article one";

        mDoc.setAbstract(title);

        assertEquals("Article one", mDoc.getAbstract());
    }

    @Test
    public void getMultimedia(){
        List<SearchResult.Doc.Multimedium> list = new ArrayList<>();

        mDoc.setMultimedia(list);

        assertEquals(list, mDoc.getMultimedia());
    }

    @Test
    public void setPubDate(){
        String date = "31/07/2019";

        mDoc.setPubDate(date);

        assertEquals("31/07/2019", mDoc.getPubDate());
    }

    @Test
    public void getSectionName(){
        String section = "Science";

        mDoc.setSectionName(section);

        assertEquals("Science", mDoc.getSectionName());
    }

    @Test
    public void getId(){
        String id = "21";

        mDoc.setId(id);

        assertEquals("21", mDoc.getId());
    }
}
