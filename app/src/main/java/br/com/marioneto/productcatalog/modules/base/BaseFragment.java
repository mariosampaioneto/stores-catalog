package br.com.marioneto.productcatalog.modules.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.annotation.Nullable;

import br.com.marioneto.productcatalog.MainApplication;
import br.com.marioneto.productcatalog.dagger.ActivityComponent;
import br.com.marioneto.productcatalog.dagger.FragmentComponent;
import br.com.marioneto.productcatalog.dagger.MainComponent;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.DefaultProgressDialog;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.SimpleConfirmationDialog;


public class BaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;
    private DefaultProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
        mProgressDialog = new DefaultProgressDialog(getContext());
    }

    private void setupFragmentComponent() {
        fragmentComponent = getMainComponent().fragmentComponent();
    }

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    protected MainApplication getMainApplication() {
        return getBaseActivity().getMainApplication();
    }

    protected MainComponent getMainComponent() {
        return getBaseActivity().getMainComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return getBaseActivity().getActivityComponent();
    }

    protected FragmentComponent getFragmentComponent() {
        return fragmentComponent;
    }

    protected void showProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    protected void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

}
