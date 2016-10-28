package br.com.marioneto.productcatalog.core.network.service;

import br.com.marioneto.productcatalog.core.model.CategoryProductList;
import br.com.marioneto.productcatalog.core.model.HighlightItemList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mario_1a on 26/10/16.
 */

public interface ProductsService {

    @GET("mobile_product_home_list")
    Observable<HighlightItemList> getHighlightProducts();

    @GET("mobile_products_by_department_filtered")
    Observable<CategoryProductList> getCategoryProducts(@Query("menuId") String categoryId, @Query("ofertas.order") String order, @Query("ofertas.dir") String direction, @Query("ofertas.offset") String offset, @Query("ofertas.limit") int limit);

    @GET("mobile_product_department_gallery/{categoryId}")
    Observable<CategoryProductList> getCategoryHighlightCategoryProducts(@Path("categoryId") String categoryId);

}
