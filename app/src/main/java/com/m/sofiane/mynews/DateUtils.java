package com.m.sofiane.mynews;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * created by Sofiane M. 2019-10-09
 */


@TargetApi(Build.VERSION_CODES.O)
public class DateUtils {

    private final static DateTimeFormatter searchedDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
    private final static DateTimeFormatter mostpopularDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter normalDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String parseSearchedDate(String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date, searchedDateTimeFormatter);
        return dateTime.format(normalDateTimeFormatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String parseNormaldDate(String date) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        return offsetDateTime.format(normalDateTimeFormatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String parseMostPopularDate(String date) {
        LocalDate dateTime = LocalDate.parse(date, mostpopularDateTimeFormatter);
        return dateTime.format(normalDateTimeFormatter);
    }
}