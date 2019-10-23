package com.m.sofiane.mynews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * created by Sofiane M.
 */
public class DateUtilsTest {
    @Test
    public void parseSearchedDate() {
        String date = "2019-10-07T15:25:00+0000";

        String changedDate = DateUtils.parseSearchedDate(date);

        assertEquals("07/10/19",changedDate);
    }

    @Test
    public void parseMostPopularDate() {
        String date = "2019-10-07";

        String changedDate = DateUtils.parseMostPopularDate(date);

        assertEquals("07/10/19",changedDate);
    }

}
