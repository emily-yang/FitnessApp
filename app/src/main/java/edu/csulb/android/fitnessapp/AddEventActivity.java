package edu.csulb.android.fitnessapp;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class AddEventActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener{
    private Date date;
    private DatePickerDialog datePicker;
    private Calendar calendar;

    EditText eventName;
    EditText eventDate;
    EditText eventResult;
    EditText eventDetails;
    Button saveButton;

    private AddEventViewModel addEventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        eventName = findViewById(R.id.event_name_field);
        eventDate = findViewById(R.id.event_date_field);
        eventResult = findViewById(R.id.event_result_field);
        eventDetails = findViewById(R.id.event_details_field);
        saveButton = findViewById(R.id.event_button);

        // disallow keyboard input of date, must use DatePicker instead
        eventDate.setFocusable(false);

        calendar = Calendar.getInstance();
        addEventViewModel = ViewModelProviders.of(this).get(AddEventViewModel.class);

        datePicker = new DatePickerDialog(this, AddEventActivity.this, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        // show date picker when date field is clicked
        eventDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                datePicker.show();
            }
        });

        // save event
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (eventName.getText() == null || eventDate.getText() == null || eventResult.getText() == null
                        || eventDetails.getText() == null)
                    Toast.makeText(AddEventActivity.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                else {
                    addEventViewModel.addEvent(new Event(
                            eventName.getText().toString(),
                            date,
                            eventResult.getText().toString(),
                            eventDetails.getText().toString()));
                    finish();
                }


            }
        });


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
                finish();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();
        eventDate.setText(date.toString().substring(0,10));
    }
}
