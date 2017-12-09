package com.example.rathana.ui_components.dialog;

import android.content.Context;
import android.widget.TimePicker;

import com.example.rathana.ui_components.base.BaseTimePickerDialog;

/**
 * Created by RATHANA on 12/9/2017.
 */

public class StartTimePicker  extends BaseTimePickerDialog{

    OnGetTimeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener= (OnGetTimeListener) context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        super.onTimeSet(view, hourOfDay, minute);
        String time="";
        if(hourOfDay<10 && minute <10) time="0"+hourOfDay+":0"+minute;
        else time=hourOfDay+":"+minute;
        listener.onPickTime(time);
    }

}
