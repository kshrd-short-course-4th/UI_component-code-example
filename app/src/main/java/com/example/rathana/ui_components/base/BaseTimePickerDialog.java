package com.example.rathana.ui_components.base;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by RATHANA on 12/9/2017.
 */

public abstract class BaseTimePickerDialog  extends DialogFragment
implements TimePickerDialog.OnTimeSetListener{

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int h=c.get(Calendar.HOUR);
        int m=c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,h,m,
                DateFormat.is24HourFormat(getActivity()));
    }

    public interface OnGetTimeListener{
        void onPickTime(String timeForam);
    }
}
