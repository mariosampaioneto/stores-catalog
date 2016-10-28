package br.com.marioneto.productcatalog.modules.main;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.modules.main.MainContract;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ProductsService productsService;

    @Inject
    public MainPresenter(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Override
    public void bindView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }
}
