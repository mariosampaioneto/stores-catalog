package br.com.marioneto.productcatalog.modules.category;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.Product;

/**
 * Created by mario_1a on 28/10/16.
 */

public interface CategoryListContract {
    interface View {
        void setCategoryList(ArrayList<CategoryItem> categoryItems);

        void showProgressDialog();

        void hideProgressDialog();

        void showErrorDialog();
    }

    interface Presenter {
        void bindView(CategoryListContract.View view);

        void unbindView();

        void requestCategory(String categoryId);
    }
}
