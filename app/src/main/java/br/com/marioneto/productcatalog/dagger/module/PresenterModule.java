package br.com.marioneto.productcatalog.dagger.module;

import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.dagger.scope.ActivityScope;
import br.com.marioneto.productcatalog.dagger.scope.FragmentScope;
import br.com.marioneto.productcatalog.modules.category.CategoryListContract;
import br.com.marioneto.productcatalog.modules.category.CategoryListPresenter;
import br.com.marioneto.productcatalog.modules.highlights.HighlightsContract;
import br.com.marioneto.productcatalog.modules.highlights.HighlightsPresenter;
import br.com.marioneto.productcatalog.modules.main.MainContract;
import br.com.marioneto.productcatalog.modules.main.MainPresenter;
import br.com.marioneto.productcatalog.modules.product.list.ProductListContract;
import br.com.marioneto.productcatalog.modules.product.list.ProductListPresenter;
import br.com.marioneto.productcatalog.modules.subcategory.SubCategoryListContract;
import br.com.marioneto.productcatalog.modules.subcategory.SubCategoryListPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainPresenter(ProductsService productsService) {
        return new MainPresenter(productsService);
    }

    @Provides
    @ActivityScope
    SubCategoryListContract.Presenter provideSubCategoryListPresenter(CategoryService categoryService, ProductsService productsService) {
        return new SubCategoryListPresenter(categoryService, productsService);
    }

    @Provides
    @ActivityScope
    ProductListContract.Presenter provideProductListPresenter(ProductsService productsService) {
        return new ProductListPresenter(productsService);
    }

    @Provides
    @FragmentScope
    HighlightsContract.Presenter provideHighlightsPresenter(ProductsService productsService) {
        return new HighlightsPresenter(productsService);
    }

    @Provides
    @FragmentScope
    CategoryListContract.Presenter provideCategoryListContract(CategoryService categoryService) {
        return new CategoryListPresenter(categoryService);
    }
}
