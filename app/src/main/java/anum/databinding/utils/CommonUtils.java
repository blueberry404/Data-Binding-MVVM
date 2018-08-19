package anum.databinding.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by ANUM on 9/19/2017.
 */

public class CommonUtils {

    public static void showAlertDialog(Context context, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public static void showAlertDialog(Context context, String message,
                                       DialogInterface.OnClickListener positiveListener,
                                       DialogInterface.OnClickListener negativeListener,
                                       String positiveButtonTitle,
                                       String negativeButtonTitle) {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Alert");
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonTitle, positiveListener);
        builder.setNegativeButton(negativeButtonTitle, negativeListener);
        builder.show();
    }
}
