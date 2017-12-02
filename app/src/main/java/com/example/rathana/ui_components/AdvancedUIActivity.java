package com.example.rathana.ui_components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rathana.ui_components.dialog.DatePickerDialogCalendar;

import java.util.ArrayList;
import java.util.List;

public class AdvancedUIActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener,
        DatePickerDialogCalendar.CallBack{

    private AutoCompleteTextView autoCompleteTextView;
    private Spinner spinner;
    private TextView dateFormat;
    String[] countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_ui);
        spinner=findViewById(R.id.spinner);
        autoCompleteTextView=findViewById(R.id.autoComplete);
        dateFormat=findViewById(R.id.dateFormat);
        final String[] items={"book","cook","pen","cake","cat","car"};
        //adapter with 3 parameters
        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line,
                items
        );*/
        //adapter with custom layout
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(
            this,R.layout.dropdown_item_list,R.id.item,items
        );
        autoCompleteTextView.setAdapter(adapter1);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("text ", autoCompleteTextView.getText().toString());
            }
        });

        //adapter for spinner
        List<String> spinnerItems=new ArrayList<>();
        spinnerItems.add("Cambodia");
        spinnerItems.add("Thailand");
        spinnerItems.add("China");
        spinnerItems.add("Korea");
        spinnerItems.add("Veitnam");

        countries=this.getResources().getStringArray(R.array.countries_res);
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line,countries
        );
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onGetText(View view) {
        Log.e("text-> ", autoCompleteTextView.getText().toString());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("spinner value",""+ countries[position]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("sppinner->",countries[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onPickDate(View view) {
        new DatePickerDialogCalendar().show(getFragmentManager(),"date picker calendar View");
    }

    @Override
    public void onPickDate(int day, int month, int year) {
        String date=""+day+"/" + month+"/"+year;
        dateFormat.setText(date);
    }
}
