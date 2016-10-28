package br.com.marioneto.productcatalog.modules.widget.custom.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import br.com.marioneto.productcatalog.R;


public class DefaultProgressDialog {

    private final Context mContext;
    private ProgressDialog mProgressDialog;

    public DefaultProgressDialog(Context context) {
        mContext = context;
    }

    public void show() {
        show(null);
    }

    public void show(DialogInterface.OnCancelListener onCancelListener) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = ProgressDialog.show(mContext, null, mContext.getString(R.string.progress_dialog_message), true, false);
    }

    public void setCancelable(DialogInterface.OnCancelListener onCancelListener) {
        if (onCancelListener != null) {
            mProgressDialog.setCancelable(true);
            mProgressDialog.setOnCancelListener(onCancelListener);
        } else {
            mProgressDialog.setCancelable(false);
            mProgressDialog.setOnCancelListener(null);
        }
    }

    public void dismiss() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

}
