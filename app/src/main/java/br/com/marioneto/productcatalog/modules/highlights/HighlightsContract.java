package br.com.marioneto.productcatalog.modules.highlights;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.Product;

/**
 * Created by mario_1a on 28/10/16.
 */

public interface HighlightsContract {
    interface View {
        void setHighlightProductList(String listTitle, String listDesc, String listImageUrl, ArrayList<Product> highlightProductList);

        void showProgressDialog();

        void hideProgressDialog();

        void showErrorDialog();
    }

    interface Presenter {
        void bindView(HighlightsContract.View view);

        void unbindView();

        void requestProducts();
    }
}
