package br.com.marioneto.productcatalog.modules.subcategory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.Product;
import br.com.marioneto.productcatalog.modules.base.BaseActivity;
import br.com.marioneto.productcatalog.modules.category.CategoryListAdapter;
import br.com.marioneto.productcatalog.modules.product.list.ProductListActivity;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.SimpleConfirmationDialog;
import br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal.ProductsHorizontalList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 28/10/16.
 */

public class SubCategoryListActivity extends BaseActivity implements SubCategoryListContract.View {

    public static final String ARGS_CAT_ID = "ARGS_CAT_ID";
    public static final String ARGS_CAT_NAME = "ARGS_CAT_NAME";

    @Inject
    SubCategoryListContract.Presenter presenter;

    @BindView(R.id.subcategory_list_recyclerview)
    RecyclerView mCategoryRecyclerView;

    ProductsHorizontalList mHighlightProductsHorizontalList;

    SubCategoryListAdapter mListAdapter;

    String mCategoryId;
    String mCategoryName;

    public static void startInstance(Context context, String categoryId, String categoryName) {
        Intent intent = new Intent(context, SubCategoryListActivity.class);

        Bundle extras = new Bundle();
        extras.putString(ARGS_CAT_ID, categoryId);
        extras.putString(ARGS_CAT_NAME, categoryName);
        intent.putExtras(extras);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_list);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        loadExtras();
        init();
    }

    private void loadExtras() {
        if (getIntent().getExtras() != null) {
            mCategoryId = getIntent().getExtras().getString(ARGS_CAT_ID);
            mCategoryName = getIntent().getExtras().getString(ARGS_CAT_NAME);
        }
    }

    private void init() {
        presenter.bindView(this);
        initializeToolbar(R.id.toolbar, true);
        setToolbarTitle(mCategoryName);
        mHighlightProductsHorizontalList = (ProductsHorizontalList) findViewById(R.id.subcategory_list_products_view);
        presenter.requestCategory(mCategoryId);
        presenter.requestProducts(mCategoryId);
    }

    @Override
    public void setCategoryList(ArrayList<CategoryItem> categoryItems) {
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCategoryRecyclerView.setHasFixedSize(false);
        mCategoryRecyclerView.setNestedScrollingEnabled(false);
        mListAdapter = new SubCategoryListAdapter(this, categoryItems);
        mListAdapter.setOnItemClickListener((view, categoryItem, position) -> {
            ProductListActivity.startInstance(this, categoryItem.getMenuId(), categoryItem.getName());
        });
        mCategoryRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void setHighlightProductsList(ArrayList<Product> productsList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mHighlightProductsHorizontalList.setTitle("");
        mHighlightProductsHorizontalList.setDescription("");
        mHighlightProductsHorizontalList.setImage("");
        mHighlightProductsHorizontalList.setRecyclerView(layoutManager, productsList);
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
    public void hideProductHighlights() {
        mHighlightProductsHorizontalList.setVisibility(View.GONE);
    }

    @Override
    public void showErrorDialog() {
        new SimpleConfirmationDialog(this).show(getString(R.string.error_dialog_title), getString(R.string.error_dialog_message), (dialog, which) -> {
            presenter.requestCategory(mCategoryId);
        });
    }
}
