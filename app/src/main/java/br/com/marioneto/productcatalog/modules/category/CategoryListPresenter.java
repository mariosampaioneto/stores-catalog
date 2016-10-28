package br.com.marioneto.productcatalog.modules.category;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.core.network.service.CategoryService;
import br.com.marioneto.productcatalog.core.network.service.ProductsService;
import br.com.marioneto.productcatalog.core.operator.WorkerOperator;
import timber.log.Timber;

/**
 * Created by mario_1a on 28/10/16.
 */

public class CategoryListPresenter implements CategoryListContract.Presenter {

    private CategoryListContract.View view;
    private CategoryService mCategoryService;

    @Inject
    public CategoryListPresenter(CategoryService categoryService) {
        this.mCategoryService = categoryService;
    }

    @Override
    public void bindView(CategoryListContract.View view) {
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
}
