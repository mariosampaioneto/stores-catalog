package br.com.marioneto.productcatalog.modules.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.marioneto.productcatalog.MainApplication;
import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.dagger.ActivityComponent;
import br.com.marioneto.productcatalog.dagger.MainComponent;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.DefaultProgressDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;
    private DefaultProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new DefaultProgressDialog(this);
        setupActivityComponent();
    }

    private void setupActivityComponent() {
        activityComponent = getMainComponent().activityComponent();
    }

    protected MainApplication getMainApplication() {
        return (MainApplication) getApplication();
    }

    protected MainComponent getMainComponent() {
        return getMainApplication().getMainComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected void initializeToolbar(int toolbarResId, boolean showUpNavigation) {
        Toolbar toolbar = (Toolbar) findViewById(toolbarResId);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar bar = getSupportActionBar();
            if (bar != null) {
                bar.setDisplayShowTitleEnabled(false);
                bar.setDisplayHomeAsUpEnabled(showUpNavigation);
                bar.setDefaultDisplayHomeAsUpEnabled(showUpNavigation);
            }
        }
    }

    public void setToolbarTitle(String title) {
        TextView titleTextView = (TextView) findViewById(R.id.toolbar_title);
        if (titleTextView != null) {
            titleTextView.setText(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
