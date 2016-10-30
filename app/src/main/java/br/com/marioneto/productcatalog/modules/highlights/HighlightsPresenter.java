package br.com.marioneto.productcatalog.modules.highlights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.core.operator.WorkerOperator;
import timber.log.Timber;

/**
 * Created by mario_1a on 28/10/16.
 */

public class HighlightsPresenter implements HighlightsContract.Presenter {

    private HighlightsContract.View view;
    private ProductsService mProductsService;
    private CategoryService mCategoryService;

    @Inject
    public HighlightsPresenter(ProductsService mProductsService, CategoryService categoryService) {
        this.mProductsService = mProductsService;
        this.mCategoryService = categoryService;
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
        mProductsService.getHighlightProducts().compose(new WorkerOperator<>()).subscribe(highlightItemList -> {
            view.setHighlightProductList(highlightItemList.getHighlightItemList().get(0).getTitle(), null, null, highlightItemList.getHighlightItemList().get(0).getList());
            view.hideProgressDialog();
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideProgressDialog();
            view.showErrorDialog();
        });
    }

    @Override
    public void requestCategory(String categoryId) {
        mCategoryService.getCategories(categoryId).compose(new WorkerOperator<>()).subscribe(categoryList -> {
            ArrayList<CategoryItem> menuItemList = categoryList.getCategoryList().get(0).getMenuItemList();
            Collections.shuffle(menuItemList);

            requestCategoryProducts(menuItemList.get(0).getMenuId(), menuItemList.get(0).getName(), HighlightsContract.CategoryHighlight.CAT_1);
            requestCategoryProducts(menuItemList.get(1).getMenuId(), menuItemList.get(1).getName(), HighlightsContract.CategoryHighlight.CAT_2);
            requestCategoryProducts(menuItemList.get(2).getMenuId(), menuItemList.get(2).getName(), HighlightsContract.CategoryHighlight.CAT_3);

        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideCategoryHighlights(HighlightsContract.CategoryHighlight.ALL);
        });
    }

    @Override
    public void requestCategoryProducts(String categoryId, String categoryTitle, HighlightsContract.CategoryHighlight categoryHighlight) {
        mProductsService.getCategoryHighlightCategoryProducts(categoryId).compose(new WorkerOperator<>()).subscribe(productList -> {
            if (!productList.getProductList().isEmpty()) {
                view.showCategoryHighlight(productList.getProductList(), categoryTitle, categoryHighlight);
            } else {
                view.hideCategoryHighlights(categoryHighlight);
            }
        }, throwable -> {
            Timber.e(throwable.getMessage());
            view.hideCategoryHighlights(categoryHighlight);
        });
    }
}
