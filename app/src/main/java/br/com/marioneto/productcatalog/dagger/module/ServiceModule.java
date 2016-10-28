package br.com.marioneto.productcatalog.dagger.module;

/**
 * Created by mario.neto on 29/09/16.
 */

import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

@Module
public class ServiceModule {

    @Reusable
    @Provides
    ProductsService providesProductsService(Retrofit retrofit) {
        return retrofit.create(ProductsService.class);
    }

    @Reusable
    @Provides
    CategoryService providesCategoryService(Retrofit retrofit) {
        return retrofit.create(CategoryService.class);
    }
}