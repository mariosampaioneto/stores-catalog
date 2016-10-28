package br.com.marioneto.productcatalog.modules.highlights;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.core.operator.WorkerOperator;
import timber.log.Timber;

/**
 * Created by mario_1a on 28/10/16.
 */

public class HighlightsPresenter implements HighlightsContract.Presenter {

    private HighlightsContract.View view;
    private ProductsService productsService;

    @Inject
    public HighlightsPresenter(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void bindView(HighlightsContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void requestProducts() {
        view.showProgressDialog();
        productsService.getHighlightProducts().compose(new WorkerOperator<>()).subscribe(highlightItemList -> {
            view.setHighlightProductList(highlightItemList.getHighlightItemList().get(0).getTitle(), null, null, highlightItemList.getHighlightItemList().get(0).getList());
            view.hideProgressDialog();
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideProgressDialog();
            view.showErrorDialog();
        });
    }
}
