package br.com.marioneto.productcatalog.dagger;

import br.com.marioneto.productcatalog.dagger.module.PresenterModule;
import br.com.marioneto.productcatalog.dagger.scope.FragmentScope;
import br.com.marioneto.productcatalog.modules.category.CategoryListFragment;
import br.com.marioneto.productcatalog.modules.highlights.HighlightsFragment;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {PresenterModule.class})
public interface FragmentComponent {
    void inject(HighlightsFragment fragment);
//
    void inject(CategoryListFragment fragment);
//
//    void inject(CallLogFragment fragment);
}
