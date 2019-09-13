package com.m.sofiane.mynews;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
    protected String mSection = "Category : ";
    protected String mBeginDate;
    protected String mEndDate;
    protected int mButtonClick;
    private DatePickerDialog.OnDateSetListener mDateSetListenerBegin;
    private DatePickerDialog.OnDateSetListener mDateSetListenerEnd;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_search);
        this.setPageTitle();
        //    this.retrieveSettings();

        mButtonEndDate = (TextView) findViewById(R.id.button_picker_end_date);
        mButtonBeginDate = (TextView) findViewById(R.id.button_picker_begin_date);
        mSearchButton = (Button) findViewById(R.id.button_search);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PageSearch.this,
                        PageSearchResult.class);
                myIntent.putExtra("sectionChecked", mSection);
                myIntent.putExtra("queryTerm", mQueryTerm);
                myIntent.putExtra("beginDate", mBeginDate);
                myIntent.putExtra("endDate", mEndDate);
                startActivity(myIntent);
                retrieveSettings();

            }});

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
            }});

                mDateSetListenerBegin = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        m = m + 1;
                        Log.d(TAG, "onDateSet : date" + m + "/" + d + "/" + y);
                        String dateB = d + "/" + m + "/" + y;
                        mButtonBeginDate.setText(dateB);
                        mBeginDate = dateB;
                    }
                };

                mDateSetListenerEnd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        m = m + 1;
                        Log.d(TAG, "onDateSet : date" + m + "/" + d + "/" + y);
                        String dateE = d + "/" + m + "/" + y;
                        mButtonEndDate.setText(dateE);
                        mEndDate = dateE;
                    }};}


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

    protected void retrieveSettings(){
        arts = (CheckBox) findViewById(R.id.checkBox_arts);
        buisness = (CheckBox) findViewById(R.id.checkBox_business);
        entrepreneurs = (CheckBox) findViewById(R.id.checkBox_entrepreneurs);
        politics = (CheckBox) findViewById(R.id.checkBox_politics);
        sports = (CheckBox) findViewById(R.id.checkBox_sports);
        travels = (CheckBox) findViewById(R.id.checkBox_travel);
        mEditTextSearchTerm = (EditText) findViewById(R.id.editText_search_term);

        mQueryTerm = mEditTextSearchTerm.getText().toString();
        if (arts.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Arts";
            mCheckBoxChecked = 0;
        }else if(buisness.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Business Day";
            mCheckBoxChecked = 1;
        }else if(entrepreneurs.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Entrepreneurs";
            mCheckBoxChecked = 2;
        }else if(politics.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Politics";
            mCheckBoxChecked = 3;
        }else if(sports.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Sports";
            mCheckBoxChecked = 4;
        }else if(travels.isChecked()){
            mCheckCheckBox = true;
            mSection = mSection+" Travel";
            mCheckBoxChecked = 5;
        }else{
            mCheckCheckBox = false;
            Toast.makeText(getBaseContext(), "Choose a section please", Toast.LENGTH_LONG).show();
        }
    }

        }


