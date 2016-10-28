package br.com.marioneto.productcatalog.modules.product.list;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.Product;

/**
 * Created by mario_1a on 28/10/16.
 */

public interface ProductListContract {
    interface View {
        void setProductList(ArrayList<Product> categoryItems);

        void updateProductList(ArrayList<Product> categoryItems);

        void showProgressDialog();

        void hideProgressDialog();

        void showErrorDialog();
    }

    interface Presenter {
        void bindView(ProductListContract.View view);

        void unbindView();

        void requestProducts(String categoryId, int productCount);

        void updateProducts(String categoryId, int productCount);
    }
}
