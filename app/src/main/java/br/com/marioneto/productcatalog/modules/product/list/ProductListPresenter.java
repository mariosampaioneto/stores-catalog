package br.com.marioneto.productcatalog.modules.product.list;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.core.operator.WorkerOperator;
import timber.log.Timber;

/**
 * Created by mario_1a on 28/10/16.
 */

public class ProductListPresenter implements ProductListContract.Presenter {

    private ProductListContract.View view;
    private ProductsService mProductService;

    @Inject
    public ProductListPresenter(ProductsService productsService) {
        this.mProductService = productsService;
    }

    @Override
    public void bindView(ProductListContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void requestProducts(String categoryId, int productCount) {
        view.showProgressDialog();
        mProductService.getCategoryProducts(categoryId, "rankasc", "asc", "0", productCount).compose(new WorkerOperator<>()).subscribe(productList -> {
            view.setProductList(productList.getProductList());
            view.hideProgressDialog();
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideProgressDialog();
            view.showErrorDialog();
        });
    }

    @Override
    public void updateProducts(String categoryId, int productCount) {
        mProductService.getCategoryProducts(categoryId, "rankasc", "asc", "0", productCount + 20).compose(new WorkerOperator<>()).subscribe(productList -> {
            view.updateProductList(productList.getProductList());
        }, throwable -> {
            Timber.e(throwable.getMessage());
        });
    }
}
