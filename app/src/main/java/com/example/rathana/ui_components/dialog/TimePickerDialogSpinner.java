package com.example.rathana.ui_components.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by RATHANA on 12/3/2017.
 */

public class TimePickerDialogSpinner extends DialogFragment
implements TimePickerDialog.OnTimeSetListener{
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.e("time->",""+hourOfDay+":"+minute);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c=Calendar.getInstance();
        int h=c.get(Calendar.HOUR);
        int m=c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),
                android.R.style.Theme_Holo_Dialog_MinWidth,
                this,h,m,
                DateFormat.is24HourFormat(getActivity()));
    }
}
