package br.com.marioneto.productcatalog.modules.product.detail;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.ProductsService;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    private ProductDetailContract.View view;
    private ProductsService productsService;

    @Inject
    public ProductDetailPresenter(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void bindView(ProductDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

//    @Override
//    public void requestProducts() {
//        productsService.getHighlightProducts().compose(new WorkerOperator<>()).subscribe(highlightItemList -> {
//            view.setHighlightProductList(highlightItemList.getHighlightItemList().get(0).getTitle(), null, null, highlightItemList.getHighlightItemList().get(0).getList());
//        }, throwable -> {
//            Timber.e(throwable.getMessage());
//        });
//    }
}
