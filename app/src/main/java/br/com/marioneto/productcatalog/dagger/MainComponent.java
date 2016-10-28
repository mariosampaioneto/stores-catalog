package br.com.marioneto.productcatalog.dagger;

import javax.inject.Singleton;

import br.com.marioneto.productcatalog.dagger.module.ApplicationModule;
import br.com.marioneto.productcatalog.dagger.module.NetworkModule;
import br.com.marioneto.productcatalog.dagger.module.ServiceModule;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
//        PreferenceModule.class,
//        SettingModule.class,
        ServiceModule.class
//        DbModule.class
})
public interface MainComponent {

    ActivityComponent activityComponent();

    FragmentComponent fragmentComponent();

}