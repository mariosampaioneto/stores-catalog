package br.com.marioneto.productcatalog.modules.highlights;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.CategoryProductList;
import br.com.marioneto.productcatalog.core.model.Product;
import br.com.marioneto.productcatalog.modules.base.BaseFragment;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.SimpleConfirmationDialog;
import br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal.ProductsHorizontalList;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 28/10/16.
 */

public class HighlightsFragment extends BaseFragment implements HighlightsContract.View {

    @Inject
    HighlightsContract.Presenter presenter;

    ProductsHorizontalList mHighlightProductsHorizontalList;
    ProductsHorizontalList mHighlightCat1ProductsHorizontalList;
    ProductsHorizontalList mHighlightCat2ProductsHorizontalList;
    ProductsHorizontalList mHighlightCat3ProductsHorizontalList;

    public HighlightsFragment() {
        // Required empty public constructor
    }

    public static HighlightsFragment newInstance() {
        HighlightsFragment fragment = new HighlightsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_highlights, container, false);
        getFragmentComponent().inject(this);
        ButterKnife.bind(this, view);
        mHighlightProductsHorizontalList = (ProductsHorizontalList) view.findViewById(R.id.main_hor_product_view);
        mHighlightCat1ProductsHorizontalList = (ProductsHorizontalList) view.findViewById(R.id.highlight_cat1);
        mHighlightCat2ProductsHorizontalList = (ProductsHorizontalList) view.findViewById(R.id.highlight_cat2);
        mHighlightCat3ProductsHorizontalList = (ProductsHorizontalList) view.findViewById(R.id.highlight_cat3);

        init();

        return view;
    }

    private void init() {
        presenter.bindView(this);
        presenter.requestProducts();
        presenter.requestCategory(getString(R.string.MAIN_CATEGORY));
    }

    @Override
    public void setHighlightProductList(String listTitle, String listDesc, String listImageUrl, ArrayList<Product> highlightProductList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mHighlightProductsHorizontalList.setTitle(listTitle);
        mHighlightProductsHorizontalList.setDescription(listDesc);
        mHighlightProductsHorizontalList.setImage(highlightProductList.get(0).getImage());
        mHighlightProductsHorizontalList.setRecyclerView(layoutManager, highlightProductList);
    }

    @Override
    public void showProgressDialog() {
        super.showProgressDialog();
    }

    @Override
    public void hideProgressDialog() {
        super.hideProgressDialog();
    }

    @Override
    public void showErrorDialog() {
        new SimpleConfirmationDialog(getContext()).show(getString(R.string.error_dialog_title), getString(R.string.error_dialog_message), (dialog, which) -> {
            presenter.requestProducts();
        });
    }

    @Override
    public void showCategoryHighlight(ArrayList<Product> products, String title, HighlightsContract.CategoryHighlight categoryHighlight) {
        ProductsHorizontalList productsHorizontalList = mHighlightCat1ProductsHorizontalList;
        if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_1) {
            productsHorizontalList = mHighlightCat1ProductsHorizontalList;
        } else if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_2) {
            productsHorizontalList = mHighlightCat2ProductsHorizontalList;
        } else if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_3) {
            productsHorizontalList = mHighlightCat3ProductsHorizontalList;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productsHorizontalList.setTitle(title);
        productsHorizontalList.setDescription(String.format(getString(R.string.fragment_highlight_highlight_sub), title));
        productsHorizontalList.setImage(products.get(0).getImage());
        productsHorizontalList.setRecyclerView(layoutManager, products);
    }

    @Override
    public void hideCategoryHighlights(HighlightsContract.CategoryHighlight categoryHighlight) {
        if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_1) {
            mHighlightCat1ProductsHorizontalList.setVisibility(View.GONE);
        } else if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_2) {
            mHighlightCat2ProductsHorizontalList.setVisibility(View.GONE);
        } else if (categoryHighlight == HighlightsContract.CategoryHighlight.CAT_3) {
            mHighlightCat3ProductsHorizontalList.setVisibility(View.GONE);
        } else {
            mHighlightCat1ProductsHorizontalList.setVisibility(View.GONE);
            mHighlightCat2ProductsHorizontalList.setVisibility(View.GONE);
            mHighlightCat3ProductsHorizontalList.setVisibility(View.GONE);
        }
    }
}
