package br.com.marioneto.productcatalog.modules.main;

public interface MainContract {

    interface View {
    }

    interface Presenter {
        void bindView(MainContract.View view);

        void unbindView();
    }

}
