package br.com.marioneto.productcatalog.modules.highlights;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.CategoryProductList;
import br.com.marioneto.productcatalog.core.model.Product;

/**
 * Created by mario_1a on 28/10/16.
 */

public interface HighlightsContract {
    public enum CategoryHighlight {
        CAT_1, CAT_2, CAT_3, ALL
    }

    interface View {
        void setHighlightProductList(String listTitle, String listDesc, String listImageUrl, ArrayList<Product> highlightProductList);

        void showProgressDialog();

        void hideProgressDialog();

        void showErrorDialog();

        void showCategoryHighlight(ArrayList<Product> products, String title, CategoryHighlight categoryHighlight);

        void hideCategoryHighlights(CategoryHighlight categoryHighlight);
    }

    interface Presenter {
        void bindView(HighlightsContract.View view);

        void unbindView();

        void requestProducts();

        void requestCategory(String categoryId);

        void requestCategoryProducts(String categoryId, String title, CategoryHighlight categoryHighlight);
    }
}
