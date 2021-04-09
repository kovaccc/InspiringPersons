package com.example.inspiringpersons.dialogs;

import android.app.DatePickerDialog;
import android.content.Context;

public class UnbuggyDatePickerDialog extends DatePickerDialog {
    UnbuggyDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        super(context, callBack, year, monthOfYear, dayOfMonth);
    }

    @Override
    protected void onStop() {
        // do nothing - do NOT call super method.
    }
}
