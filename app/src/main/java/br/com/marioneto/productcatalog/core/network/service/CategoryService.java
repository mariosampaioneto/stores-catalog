package br.com.marioneto.productcatalog.core.network.service;


import br.com.marioneto.productcatalog.core.model.CategoryList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mario_1a on 26/10/16.
 */

public interface CategoryService {

    @GET("mobile_departments/{categoryId}")
    Observable<CategoryList> getCategories(@Path("categoryId") String categoryId);

}
