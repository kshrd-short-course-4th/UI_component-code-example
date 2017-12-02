package com.example.rathana.ui_components.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by RATHANA on 12/2/2017.
 */

public class DatePickerDialogCalendar extends DialogFragment
implements DatePickerDialog.OnDateSetListener{
    CallBack callBack;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        int m=c.get(Calendar.MONTH);
        int d=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,y,m,d);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month=month+1;
       String pickDate="" + dayOfMonth+"/"+ month +"/"+year;
        Log.e("date-> ", pickDate);
        callBack.onPickDate(dayOfMonth,month,year);
    }

    public interface CallBack{
        void onPickDate(int day,int month,int year);
    }
}
