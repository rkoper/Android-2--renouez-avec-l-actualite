package com.m.sofiane.mynews.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.m.sofiane.mynews.MyAlarm;
import com.m.sofiane.mynews.PageSearch;
import com.m.sofiane.mynews.PageSearchResult;
import com.m.sofiane.mynews.R;

import java.util.Calendar;


public class PageNotification extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    protected String mQueryTerm;
    EditText mEditTextSearchTerm;
    protected String mSection;
    Switch mSwitch;
    TextView mText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_notification);

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        mSwitch = (Switch) findViewById(R.id.switchCheck);
        mSwitch.setOnCheckedChangeListener(this);

        mText = (TextView) findViewById(R.id.textView2) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notifications");

        configureToolBar();
        retrieveSettings();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent BackInBack = new Intent(this, MainActivity.class);
                startActivity(BackInBack);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_page_toolbar, menu);
        return true;
    }

    private void configureToolBar() {
        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);
    }

    protected void retrieveSettings() {
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


            if(mSwitch.isChecked()) {
               mText.setText("Test : switch on");
                CheckBox arts;
                CheckBox buisness;
                CheckBox entrepreneurs;
                CheckBox politics;
                CheckBox sports;
                CheckBox travels;

                mEditTextSearchTerm = (EditText) findViewById(R.id.editText_search_term2);
                mQueryTerm = mEditTextSearchTerm.getText().toString();
                mQueryTerm = mQueryTerm + "Test";


                arts = (CheckBox) findViewById(R.id.checkBox_arts2);
                buisness = (CheckBox) findViewById(R.id.checkBox_business2);
                entrepreneurs = (CheckBox) findViewById(R.id.checkBox_entrepreneurs2);
                politics = (CheckBox) findViewById(R.id.checkBox_politics2);
                sports = (CheckBox) findViewById(R.id.checkBox_sports2);
                travels = (CheckBox) findViewById(R.id.checkBox_travel2);

                mSection = "news_desk(";
                if (arts.isChecked()) {
                    mSection += "\"Arts\"";
                }
                if (buisness.isChecked()) {
                    mSection += "\"buisness\"";
                }
                if (entrepreneurs.isChecked()) {
                    mSection += "\"entrepreneurs\"";
                }
                if (politics.isChecked()) {
                    mSection += "\"politics\"";
                }
                if (sports.isChecked()) {
                    mSection += "\"sports\"";
                }
                if (travels.isChecked()) {
                    mSection += "\"travels\"";
                }
                mSection = mSection + ")";

               mSection = mSection + "Test";

                setAlarm();

            }
            else {
                mText.setText("Test : Switch off");
            }
            

    }

    private void setAlarm() {


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0 );

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND,00);

        long startUpTime = calendar.getTimeInMillis();
        if (System.currentTimeMillis() > startUpTime) {
            startUpTime = startUpTime + 24*60*60*1000;
        }
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                startUpTime, AlarmManager.INTERVAL_DAY, pendingIntent);
    }


}





        /**
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_notification);

        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notifications");


        this.configureToolBar();
        this.cleanElement();
        this.SaveElement();
        this.retrieveSettings();
    }


    private void configureToolBar() {
        Toolbar toolbar = findViewById(R.id.simple_toolbar);
        setSupportActionBar(toolbar);
    }

    protected void cleanElement() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void SaveElement() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(TERM, mQueryTerm);
        editor.putString(SECTION, mSection);
        editor.putBoolean(BUT, mNotification);
        editor.putInt(BUT_CHECK, mCheckBoxChecked);
        editor.apply();
    }

    protected void retrieveSettings() {

        mEditTextSearchTerm = (EditText) findViewById(R.id.editText_search_term);
        mQueryTerm = mEditTextSearchTerm.getText().toString();

        arts = (CheckBox) findViewById(R.id.checkBox_arts);
        buisness = (CheckBox) findViewById(R.id.checkBox_business);
        entrepreneurs = (CheckBox) findViewById(R.id.checkBox_entrepreneurs);
        politics = (CheckBox) findViewById(R.id.checkBox_politics);
        sports = (CheckBox) findViewById(R.id.checkBox_sports);
        travels = (CheckBox) findViewById(R.id.checkBox_travel);


        mSection = "news_desk(";
        if (arts.isChecked()) {
            mSection += "\"Arts\"";
        }
        if (buisness.isChecked()) {
            mSection += "\"buisness\"";
        }
        if (entrepreneurs.isChecked()) {
            mSection += "\"entrepreneurs\"";
        }
        if (politics.isChecked()) {
            mSection += "\"politics\"";
        }
        if (sports.isChecked()) {
            mSection += "\"sports\"";
        }
        if (travels.isChecked()) {
            mSection += "\"travels\"";
        }
        mSection = mSection + ")";

    }


        }

**/