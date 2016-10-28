package br.com.marioneto.productcatalog.dagger;

import br.com.marioneto.productcatalog.core.model.ProductList;
import br.com.marioneto.productcatalog.dagger.module.PresenterModule;
import br.com.marioneto.productcatalog.dagger.scope.ActivityScope;
import br.com.marioneto.productcatalog.modules.product.detail.ProductDetailActivity;
import br.com.marioneto.productcatalog.modules.main.MainActivity;
import br.com.marioneto.productcatalog.modules.product.list.ProductListActivity;
import br.com.marioneto.productcatalog.modules.subcategory.SubCategoryListActivity;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {PresenterModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SubCategoryListActivity activity);

    void inject(ProductListActivity activity);

    void inject(ProductDetailActivity activity);

}