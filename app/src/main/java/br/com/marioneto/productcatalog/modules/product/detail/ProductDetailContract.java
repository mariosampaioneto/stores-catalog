package br.com.marioneto.productcatalog.modules.product.detail;

public interface ProductDetailContract {

    interface View {
//        void setHighlightProductList(String listTitle, String listDesc, String listImageUrl, ArrayList<Product> highlightProductList);
    }

    interface Presenter {
        void bindView(ProductDetailContract.View view);

        void unbindView();

//        void requestProducts();
    }

}
