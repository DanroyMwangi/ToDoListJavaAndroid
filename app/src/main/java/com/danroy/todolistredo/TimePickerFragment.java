package com.danroy.todolistredo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private static String timeSet;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        return new TimePickerDialog(getContext(), this,c.get(Calendar.HOUR),c.get(Calendar.MINUTE),true);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView timeChosen = ((Activity)getContext()).findViewById(R.id.timeChosenDisplay);
        Calendar selectedTime = Calendar.getInstance();
        selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
        selectedTime.set(Calendar.MINUTE,minute);

        timeSet = selectedTime.get(Calendar.HOUR_OF_DAY) + ":"+selectedTime.get(Calendar.MINUTE);
        Toast.makeText(getContext(),timeSet,Toast.LENGTH_SHORT).show();
        timeChosen.setText("Time proposed - "+ selectedTime.get(Calendar.HOUR_OF_DAY) + ":"+selectedTime.get(Calendar.MINUTE));
    }

    public static String getTimeSet() {
        return timeSet;
    }
}
