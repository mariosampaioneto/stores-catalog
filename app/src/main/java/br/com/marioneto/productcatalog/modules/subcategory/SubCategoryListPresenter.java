package br.com.marioneto.productcatalog.modules.subcategory;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.core.operator.WorkerOperator;
import timber.log.Timber;

/**
 * Created by mario_1a on 28/10/16.
 */

public class SubCategoryListPresenter implements SubCategoryListContract.Presenter {

    private SubCategoryListContract.View view;
    private ProductsService mProductsService;
    private CategoryService mCategoryService;

    @Inject
    public SubCategoryListPresenter(CategoryService categoryService, ProductsService productService) {
        this.mCategoryService = categoryService;
        this.mProductsService = productService;
    }

    @Override
    public void bindView(SubCategoryListContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void requestCategory(String categoryId) {
        view.showProgressDialog();
        mCategoryService.getCategories(categoryId).compose(new WorkerOperator<>()).subscribe(categoryList -> {
            Timber.d("%s", categoryList.getCategoryList().get(0).getName());
            view.setCategoryList(categoryList.getCategoryList().get(0).getMenuItemList());
            view.hideProgressDialog();
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideProgressDialog();
            view.showErrorDialog();
        });
    }

    @Override
    public void requestProducts(String categoryId) {
        mProductsService.getCategoryHighlightCategoryProducts(categoryId).compose(new WorkerOperator<>()).subscribe(productList -> {
            if (!productList.getProductList().isEmpty()) {
                view.setHighlightProductsList(productList.getProductList());
            } else {
                view.hideProductHighlights();
            }
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideProductHighlights();
        });
    }
}
