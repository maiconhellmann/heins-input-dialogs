package br.com.forusers.heinsinputdialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import br.com.forusers.heinsinputdialogs.interfaces.OnSelectDateListener;


public class HeinsDatePickerDialog extends DialogFragment implements android.app.DatePickerDialog.OnDateSetListener {

    private OnSelectDateListener listener;
    private android.app.DatePickerDialog dialog;
    private Date date;

    public void setListener(OnSelectDateListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();

        if (date != null) {
            c.setTime(date);
        }

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        dialog = new android.app.DatePickerDialog(getActivity(), this, year, month, day);

        dialog.show();
        try {
            final Button positive = dialog.getButton(android.app.DatePickerDialog.BUTTON_POSITIVE);
            positive.setText(android.R.string.ok);
        } catch (Exception e) {
            Log.e(getClass().getName(), "Erro ao alterar label do datePicker", e);
        }

        return dialog;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);

        //This snippets is used to change label of the "ok" buttun to automated tests use
//        if (dialog != null) {
//            try {
//                final Button positive = dialog.getButton(android.app.DatePickerDialog.BUTTON_POSITIVE);
//                positive.setText(android.R.string.ok);
//            } catch (Exception e) {
//                Log.e(getClass().getName(), "Erro ao alterar label do datePicker", e);
//            }
//        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);

            listener.onSelectDate(calendar.getTime());
        } catch (Exception e) {
            Log.e(getClass().getName(), "Erro ao atribuir data.", e);
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }
}