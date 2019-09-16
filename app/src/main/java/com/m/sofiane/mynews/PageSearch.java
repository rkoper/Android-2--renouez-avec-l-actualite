package com.m.sofiane.mynews;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Printer;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.internal.Utils;

public class PageSearch extends AppCompatActivity {

    public static final String TAG = "PageSearch";

    @BindView(R.id.textView_begin_date) TextView beginDate;
    @BindView(R.id.button_picker_begin_date) TextView mButtonBeginDate;
    @BindView(R.id.button_picker_end_date) TextView mButtonEndDate;
    @BindView(R.id.editText_search_term) EditText mEditTextSearchTerm;
    @BindView(R.id.button_search) Button mSearchButton;
    @BindView(R.id.checkBox_arts) CheckBox arts;
    @BindView(R.id.checkBox_business) CheckBox buisness;
    @BindView(R.id.checkBox_entrepreneurs) CheckBox entrepreneurs;
    @BindView(R.id.checkBox_politics) CheckBox politics;
    @BindView(R.id.checkBox_sports) CheckBox sports;
    @BindView( R.id.checkBox_travel) CheckBox travels;



    protected boolean mCheckCheckBox;
    protected boolean mCheckEditText;
    protected int mCheckBoxChecked;
    protected String mQueryTerm;
    protected String mSection ;
    protected String mBeginDate;
    protected String mEndDate;
    protected int mButtonClick;
    private DatePickerDialog.OnDateSetListener mDateSetListenerBegin;
    private DatePickerDialog.OnDateSetListener mDateSetListenerEnd;
    private String mDay;
    private String mMonth;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_search);
        this.setPageTitle();


        mButtonEndDate = (TextView) findViewById(R.id.button_picker_end_date);
        mButtonBeginDate = (TextView) findViewById(R.id.button_picker_begin_date);
        mSearchButton = (Button) findViewById(R.id.button_search);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PageSearch.this,
                        PageSearchResult.class);
                retrieveSettings();
                myIntent.putExtra("fq", mSection);
                myIntent.putExtra("q", mQueryTerm);
                myIntent.putExtra("begin_date", mBeginDate);
                myIntent.putExtra("end_date", mEndDate);
                startActivity(myIntent);
            }
        });

        mButtonBeginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                final int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(PageSearch.this, mDateSetListenerBegin, year, month, day);
                dialog.getWindow();
                dialog.show();
            }
        });
        mButtonEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                final int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(PageSearch.this, mDateSetListenerEnd, year, month, day);
                dialog.getActionBar();
                dialog.show();
            }
        });

        mDateSetListenerBegin = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                m = m+1;
                if (m <= 9){
                    mMonth = ""+0+m;
                }else{
                    mMonth = ""+m;}
                if (d <= 9){
                    mDay = ""+0+d;
                }else{
                    mDay = ""+d;}

                Log.d(TAG, "onDateSet : date" + mMonth + mDay + y);
                String dateB = y + "" + mMonth + "" + mDay;
                mButtonBeginDate.setText(dateB);
                mBeginDate = dateB;
            }
        };

        mDateSetListenerEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                m = m+1;
                if (m <= 9){
                    mMonth = ""+0+m;
                }else{
                    mMonth = ""+m;}

                if (d <= 9){
                    mDay = ""+0+d;
                }else{
                    mDay = ""+d;}
                Log.d(TAG, "onDateSet : date" + mMonth + "" + mDay + "" + y);
                String dateE = y + "" + mMonth + "" + mDay;
                mButtonEndDate.setText(dateE);
                mEndDate = dateE;
            }
        };

    }



    public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.activity_page_toolbar, menu);
                return true;
            }

            private void setPageTitle() {
                Toolbar toolbar = findViewById(R.id.simple_toolbar);
                setSupportActionBar(toolbar);

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setTitle("Search Articles");
            }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected void retrieveSettings(){

        mEditTextSearchTerm = (EditText) findViewById(R.id.editText_search_term);
        mQueryTerm = mEditTextSearchTerm.getText().toString();

        arts = (CheckBox) findViewById(R.id.checkBox_arts);
        buisness = (CheckBox) findViewById(R.id.checkBox_business);
        entrepreneurs = (CheckBox) findViewById(R.id.checkBox_entrepreneurs);
        politics = (CheckBox) findViewById(R.id.checkBox_politics);
        sports = (CheckBox) findViewById(R.id.checkBox_sports);
        travels = (CheckBox) findViewById(R.id.checkBox_travel);


        mSection ="news_desk(";
        if (arts.isChecked())
        { mSection += "\"Arts\""; }
        if (buisness.isChecked())
        {mSection+= "\"buisness\""; }
        if(entrepreneurs.isChecked())
        {mSection += "\"entrepreneurs\""; }
        if(politics.isChecked())
        {mSection += "\"politics\"";
        }if(sports.isChecked()){
            mSection += "\"sports\"";
        }if(travels.isChecked())
        {mSection += "\"travels\""; }
        mSection = mSection+")";

    }
        }

