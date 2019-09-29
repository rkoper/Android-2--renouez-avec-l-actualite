package com.m.sofiane.mynews.activity;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.m.sofiane.mynews.MyAlarm;
import com.m.sofiane.mynews.R;
import java.util.Calendar;

public class PageNotification extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    protected String mQueryTerm;
    private EditText mEditTextSearchTerm;
    protected String mSection;
    private Switch mSwitch;
    private TextView mText;
    protected String mArts;
    protected String mBusiness;
    protected String mEntrepreneurs;
    protected String mPolitics;
    protected String mSports;
    protected String mTravel;
    private String SEARCHWORD = "term";
    private String SEARCHSECTION = "section";
    private String SEArCHSWITCH = "switch";
    private String ARTS = "arts";
    private String BUSINESS = "business";
    private String ENTREPRENEURS = "entrepreneurs";
    private String POLITICS = "politics";
    private String SPORTS = "sports";
    private String TRAVEL = "travel";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_notification);

        mSwitch = (Switch) findViewById(R.id.switchCheck);
        mSwitch.setOnCheckedChangeListener(this);

        configureToolBar();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_page_toolbar, menu);
        return true;
    }

    private void configureToolBar() {

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        mText = (TextView) findViewById(R.id.textView2);

        if(mSwitch.isChecked()) {
            setAlarm();
        }
        else {
            mText.setText("Test : OFF");
            mSwitch.setChecked(false);
        }
    }

    private void setAlarm() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 16);
        cal.set(Calendar.MINUTE, 47);
        cal.set(Calendar.SECOND, 00);



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

        mEditTextSearchTerm = (EditText) findViewById(R.id.editText_search_term2);
        mQueryTerm = mEditTextSearchTerm.getText().toString();

        arts = (CheckBox) findViewById(R.id.checkBox_arts2);
        buisness = (CheckBox) findViewById(R.id.checkBox_business2);
        entrepreneurs = (CheckBox) findViewById(R.id.checkBox_entrepreneurs2);
        politics = (CheckBox) findViewById(R.id.checkBox_politics2);
        sports = (CheckBox) findViewById(R.id.checkBox_sports2);
        travels = (CheckBox) findViewById(R.id.checkBox_travel2);

        SharedPreferences.Editor SaveBox = getSharedPreferences("My Box", MODE_PRIVATE).edit();

        if (arts.isChecked()) {
            mArts = "\"arts\"";
        }
        else {mArts="";}
        SaveBox.putString(ARTS, mArts);

        if (buisness.isChecked()) {
            mBusiness = "\"buisness\"";
        }
        else {mBusiness="";}
        SaveBox.putString(BUSINESS, mSection);

        if (entrepreneurs.isChecked()) {
            mEntrepreneurs = "\"entrepreneurs\""; }
        else {mEntrepreneurs="";}
        SaveBox.putString(ENTREPRENEURS, mEntrepreneurs);

        if (politics.isChecked()) {
            mPolitics = "\"politics\""; }
        else {mPolitics="";}
        SaveBox.putString(POLITICS, mPolitics);

        if (sports.isChecked()) {
            mSports = "\"sports\""; }
        else {mSports="";}
        SaveBox.putString(SPORTS, mSports);

        if (travels.isChecked()) {
            mTravel = "\"travels\""; }
        else {mTravel="";}
        SaveBox.putString(TRAVEL, mTravel);

        mSection = "news_desk(" + mArts+mBusiness+mEntrepreneurs+mPolitics+mSports+mTravel;
        mSection = mSection + ")";

        SharedPreferences.Editor saveChoice = getSharedPreferences("My settings", MODE_PRIVATE).edit();
        saveChoice.putString(SEARCHWORD, mQueryTerm);
        saveChoice.putString(SEArCHSWITCH, String.valueOf(mSwitch));
        saveChoice.putString(SEARCHSECTION, mSection);
        saveChoice.apply();
    }
}