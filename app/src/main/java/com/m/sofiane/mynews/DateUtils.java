package com.m.sofiane.mynews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * created by Sofiane M. 2019-10-30
 */
public class DateUtils {


    public static String simplifyDateFormat(String rawDate) throws ParseException {
        Date simpleDate;
        if (rawDate != null) {
            SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE);
            SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy");
            simpleDate = sdfIn.parse(rawDate);
            rawDate = sdfOut.format(simpleDate);
        }
        return rawDate;
    }

    public static String simplifyDateFormatMost(String rawDate) throws ParseException {
        Date simpleDate;
        if (rawDate != null) {
            SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
            SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy");
            simpleDate = sdfIn.parse(rawDate);
            rawDate = sdfOut.format(simpleDate);
        }
        return rawDate;
    }

    public static String dateStringLayoutFormat(int y, int m, int d) {
        String dateFormat;

        if (d < 10) {
            dateFormat = ("0" + d);
        } else {
            dateFormat = ("" + d);
        }

        if (m < 9) {
            dateFormat = (dateFormat + "/0" + (m + 1));
        } else {
            dateFormat = (dateFormat + "/" + (m + 1));
        }

        dateFormat = dateFormat + ("/" + y);

        return dateFormat;
    }

    public static String dateStringFormat(int year, int month, int dayOfMonth) {
        String dateLayoutFormat;

        dateLayoutFormat = (year+"");

        if(month < 9) {
            dateLayoutFormat = (dateLayoutFormat+"0"+(month+1));
        }
        else {
            dateLayoutFormat = (dateLayoutFormat+(month+1));
        }

        if(dayOfMonth < 10) {
            dateLayoutFormat = (dateLayoutFormat+"0"+dayOfMonth);
        }
        else {
            dateLayoutFormat = (dateLayoutFormat+dayOfMonth);
        }

        return dateLayoutFormat;
    }


}