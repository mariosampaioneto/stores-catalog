package br.com.marioneto.productcatalog;

import android.app.Application;

import com.facebook.stetho.Stetho;

import br.com.marioneto.productcatalog.dagger.DaggerMainComponent;
import br.com.marioneto.productcatalog.dagger.MainComponent;
import br.com.marioneto.productcatalog.dagger.module.ApplicationModule;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by mario_1a on 26/10/16.
 */

public class MainApplication extends Application {

    private MainComponent mainComponent;

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initCalligraphy();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            initTimber();
        } else {
//            initCrashlytics();
        }
    }

    private void initDagger() {
        mainComponent = DaggerMainComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initTimber() {
        Timber.plant(new Timber.DebugTree());
//        Timber.plant(new CrashlyticsTree());
    }

    private void initCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
