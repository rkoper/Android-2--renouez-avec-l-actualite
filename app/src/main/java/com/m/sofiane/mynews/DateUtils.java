package com.m.sofiane.mynews;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import butterknife.BindView;

/**
 * created by Sofiane M. 2019-10-09
 */
public class DateUtils {

    private final static DateTimeFormatter searchedDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
    private final static DateTimeFormatter mostpopularDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter normalDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");


    public static String parseSearchedDate(String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date, searchedDateTimeFormatter);
        return dateTime.format(normalDateTimeFormatter);
    }

    public static String parseNormaldDate(String date) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        return offsetDateTime.format(normalDateTimeFormatter);
    }

    public static String parseMostPopularDate(String date) {
        LocalDate dateTime = LocalDate.parse(date, mostpopularDateTimeFormatter);
        return dateTime.format(normalDateTimeFormatter);
    }
}