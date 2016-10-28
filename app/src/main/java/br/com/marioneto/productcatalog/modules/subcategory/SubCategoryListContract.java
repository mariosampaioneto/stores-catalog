package br.com.marioneto.productcatalog.modules.subcategory;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.Product;

/**
 * Created by mario_1a on 28/10/16.
 */

public interface SubCategoryListContract {
    interface View {
        void setCategoryList(ArrayList<CategoryItem> categoryItems);

        void setHighlightProductsList(ArrayList<Product> productsList);

        void showProgressDialog();

        void hideProgressDialog();

        void hideProductHighlights();

        void showErrorDialog();
    }

    interface Presenter {
        void bindView(SubCategoryListContract.View view);

        void unbindView();

        void requestCategory(String categoryId);

        void requestProducts(String categoryId);
    }
}
