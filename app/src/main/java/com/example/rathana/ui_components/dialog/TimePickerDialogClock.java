package com.example.rathana.ui_components.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by RATHANA on 12/3/2017.
 */

public class TimePickerDialogClock extends DialogFragment

implements TimePickerDialog.OnTimeSetListener{
    CallBack callBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack= (CallBack) context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.e("time->",""+hourOfDay+":"+minute);
            callBack.getTime(hourOfDay+"");
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c=Calendar.getInstance();
        int h=c.get(Calendar.HOUR);
        int m=c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,h,m,
                DateFormat.is24HourFormat(getActivity()));
    }
    public  interface CallBack{
        public void getTime(String string);
    }
}
