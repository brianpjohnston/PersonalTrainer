package com.johnston.brian.personaltrainer;

/**
 * Created by brian on 9/5/2016.
 */
        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;

public class DialogFragment extends android.app.DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Logging Off")
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .create();
    }
}