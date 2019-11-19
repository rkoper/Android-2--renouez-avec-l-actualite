package com.m.sofiane.mynews;

import com.m.sofiane.mynews.utils.DateUtils;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * created by Sofiane M. 2019-11-03
 */
public class UtilsTestDate {

    @Test
    public void changeDateFormat() {
        String inDate;
        String outDate;

        inDate = "2019-11-01T18:28:21";
        try {
            outDate = DateUtils.simplifyDateFormat(inDate);
            assertEquals("01/11/2019", outDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeDateFormatMost() {
        String inDate;
        String outDate;

        inDate = "2019-11-01";
        try {
            outDate = DateUtils.simplifyDateFormatMost(inDate);
            assertEquals("01/11/2019", outDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
