package com.m.sofiane.mynews.controler.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.m.sofiane.mynews.utils.MyAlarm;
import com.m.sofiane.mynews.R;
import java.util.Calendar;

public class PageNotification extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private String mSection;
    private Switch mSwitch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_notification);

        mSwitch = findViewById(R.id.switchCheck);
        mSwitch.setOnCheckedChangeListener(this);

        configureToolBar();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;}

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_page_toolbar, menu);
        return true;
    }

    private void configureToolBar() {
        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notification");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        if(mSwitch.isChecked()) {
            setAlarm();
        }
        else {
            mSwitch.setChecked(false);
        }
    }

    private void setAlarm() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 18);
        cal.set(Calendar.MINUTE, 00);


        Intent notificationIntent = new Intent(getApplicationContext(), MyAlarm.class);

        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, broadcast);
        retrieveSettings();
    }

    private void retrieveSettings() {
        CheckBox arts;
        CheckBox buisness;
        CheckBox entrepreneurs;
        CheckBox politics;
        CheckBox sports;
        CheckBox travels;

        EditText editTextSearchTerm = findViewById(R.id.editText_search_term2);
        String queryTerm = editTextSearchTerm.getText().toString();

        arts = findViewById(R.id.checkBox_arts2);
        buisness = findViewById(R.id.checkBox_business2);
        entrepreneurs = findViewById(R.id.checkBox_entrepreneurs2);
        politics = findViewById(R.id.checkBox_politics2);
        sports = findViewById(R.id.checkBox_sports2);
        travels = findViewById(R.id.checkBox_travel2);

        SharedPreferences.Editor SaveBox = getSharedPreferences("My Box", MODE_PRIVATE).edit();

        String arts1;
        if (arts.isChecked()) {
            arts1 = "\"arts\"";
        }
        else {
            arts1 ="";}
        String ARTS = "arts";
        SaveBox.putString(ARTS, arts1);

        String business;
        if (buisness.isChecked()) {
            business = "\"buisness\"";
        }
        else {
            business ="";}
        String BUSINESS = "business";
        SaveBox.putString(BUSINESS, mSection);

        String entrepreneurs1;
        if (entrepreneurs.isChecked()) {
            entrepreneurs1 = "\"entrepreneurs\""; }
        else {
            entrepreneurs1 ="";}
        String ENTREPRENEURS = "entrepreneurs";
        SaveBox.putString(ENTREPRENEURS, entrepreneurs1);

        String politics1;
        if (politics.isChecked()) {
            politics1 = "\"politics\""; }
        else {
            politics1 ="";}
        String POLITICS = "politics";
        SaveBox.putString(POLITICS, politics1);

        String sports1;
        if (sports.isChecked()) {
            sports1 = "\"sports\""; }
        else {
            sports1 ="";}
        String SPORTS = "sports";
        SaveBox.putString(SPORTS, sports1);

        String travel;
        if (travels.isChecked()) {
            travel = "\"travels\""; }
        else {
            travel ="";}
        String TRAVEL = "travel";
        SaveBox.putString(TRAVEL, travel);

        mSection = "news_desk(" + arts1 + business + entrepreneurs1 + politics1 + sports1 + travel;
        mSection = mSection + ")";

        SharedPreferences.Editor saveChoice = getSharedPreferences("My  settings", MODE_PRIVATE).edit();
        String SEARCHWORD = "term";
        saveChoice.putString(SEARCHWORD, queryTerm);
        String SEArCHSWITCH = "switch";
        saveChoice.putString(SEArCHSWITCH, String.valueOf(mSwitch));
        String SEARCHSECTION = "section";
        saveChoice.putString(SEARCHSECTION, mSection);
        saveChoice.apply();

}}