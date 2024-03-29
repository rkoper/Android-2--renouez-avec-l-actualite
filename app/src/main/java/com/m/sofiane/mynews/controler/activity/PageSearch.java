package com.m.sofiane.mynews.controler.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m.sofiane.mynews.utils.DateUtils;
import com.m.sofiane.mynews.R;

import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;

public class PageSearch extends AppCompatActivity {

    private static final String TAG = "PageSearch";

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



    private String mQueryTerm;
    private String mSection ;
    private String mBeginDate;
    private String mEndDate;
    private DatePickerDialog.OnDateSetListener mDateSetListenerBegin;
    private DatePickerDialog.OnDateSetListener mDateSetListenerEnd;
    private String mDay;
    private String mMonth;
    private String mDate;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_search);
        this.setPageTitle();

        datepicker();
        dateListenner();
        searchOption();



       }

    private void searchOption() {
        mSearchButton = findViewById(R.id.button_search);

        mSearchButton.setOnClickListener(view -> {
            if (CheckCheckBox()) {
                Toast.makeText(getBaseContext(), "Please Choose category", Toast.LENGTH_LONG).show();
            }
            else
            { mSearchButton.setVisibility(View.VISIBLE);
                Intent myIntent = new Intent(PageSearch.this,
                        PageSearchResult.class);
                retrieveSettings();
                myIntent.putExtra("fq", mSection);
                myIntent.putExtra("q", mQueryTerm);
                myIntent.putExtra("begin_date", mBeginDate);
                myIntent.putExtra("end_date", mEndDate);
                startActivity(myIntent);}
        });
    }

    private void dateListenner() {
        mDateSetListenerBegin = (datePicker, y, m, d) -> {
            mDate = DateUtils.dateStringLayoutFormat(y, m, d);
            mButtonBeginDate.setText(mDate);

            mBeginDate = DateUtils.dateStringFormat(y, m, d);
        };

        mDateSetListenerEnd = (datePicker, y, m, d) -> {
                mDate = DateUtils.dateStringLayoutFormat(y, m, d);
                mButtonEndDate.setText(mDate);

            mEndDate = DateUtils.dateStringFormat(y, m, d);
        };
    }

    private void datepicker() {
        mButtonEndDate = findViewById(R.id.button_picker_end_date);
        mButtonBeginDate = findViewById(R.id.button_picker_begin_date);

        mButtonBeginDate.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            final int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(PageSearch.this, mDateSetListenerBegin, year, month, day);
            dialog.getWindow();
            dialog.show();
        });
        mButtonEndDate.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            final int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(PageSearch.this, mDateSetListenerEnd, year, month, day);
            dialog.getActionBar();
            dialog.show();
        });

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

    private void retrieveSettings() {

        mEditTextSearchTerm = findViewById(R.id.editText_search_term);
        mQueryTerm = mEditTextSearchTerm.getText().toString();

        arts = findViewById(R.id.checkBox_arts);
        buisness = findViewById(R.id.checkBox_business);
        entrepreneurs = findViewById(R.id.checkBox_entrepreneurs);
        politics = findViewById(R.id.checkBox_politics);
        sports = findViewById(R.id.checkBox_sports);
        travels = findViewById(R.id.checkBox_travel);


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


        if (Objects.equals(mSection, "news_desk()")) {
            mSection = null;
        } else {
            mSection = mSection + ")";
        }

    }

        private boolean CheckCheckBox(){
            arts = findViewById(R.id.checkBox_arts);
            buisness = findViewById(R.id.checkBox_business);
            entrepreneurs = findViewById(R.id.checkBox_entrepreneurs);
            politics = findViewById(R.id.checkBox_politics);
            sports = findViewById(R.id.checkBox_sports);
            travels = findViewById(R.id.checkBox_travel);

            return !arts.isChecked() && !buisness.isChecked() && !entrepreneurs.isChecked() && !politics.isChecked() && !sports.isChecked() && !travels.isChecked();
    }
}




