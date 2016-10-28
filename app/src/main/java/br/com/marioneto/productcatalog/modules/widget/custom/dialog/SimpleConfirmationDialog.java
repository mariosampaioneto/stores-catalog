package br.com.marioneto.productcatalog.modules.widget.custom.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;

public class SimpleConfirmationDialog {

    private final Context mContext;
    private AlertDialog mProgressDialog;

    public SimpleConfirmationDialog(Context context) {
        mContext = context;
    }

    public void show(String title, String message, OnClickListener positiveOnClickListener) {
        show(title, message, positiveOnClickListener, null);
    }

    public void show(String title, String message, OnClickListener positiveOnClickListener, OnClickListener negativeOnClickListener) {
        mProgressDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, positiveOnClickListener)
                .setNegativeButton(android.R.string.cancel, negativeOnClickListener)
                .setCancelable(true)
                .show();
    }

    public void show(int title, int message, OnClickListener positiveOnClickListener) {
        show(title, message, positiveOnClickListener, null);
    }

    public void show(int title, int message, OnClickListener positiveOnClickListener, OnClickListener negativeOnClickListener) {
        mProgressDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, positiveOnClickListener)
                .setNegativeButton(android.R.string.cancel, negativeOnClickListener)
                .setCancelable(true)
                .show();
    }

    public void dismiss() {
        mProgressDialog.dismiss();
    }

}
