package com.m.sofiane.mynews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * created by Sofiane M. 2019-11-03
 */
public class UtilsTestCalendar {
    @Test
    public void formatDateForDisplay() {

        String displayedDate;

        displayedDate = DateUtils.dateStringLayoutFormat(2019, 10, 19);
        assertEquals("19/11/2019", displayedDate);

        displayedDate = DateUtils.dateStringLayoutFormat(2019, 9, 19);
        assertEquals("19/10/2019", displayedDate);

        displayedDate = DateUtils.dateStringLayoutFormat(2019, 11, 9);
        assertEquals("09/12/2019", displayedDate);
    }
}