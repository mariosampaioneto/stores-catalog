package br.com.marioneto.productcatalog.modules.product.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.model.Product;
import br.com.marioneto.productcatalog.modules.base.BaseActivity;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.SimpleConfirmationDialog;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 28/10/16.
 */

public class ProductListActivity extends BaseActivity implements ProductListContract.View {

    public static final String ARGS_CAT_ID = "ARGS_CAT_ID";
    public static final String ARGS_CAT_NAME = "ARGS_CAT_NAME";

    @Inject
    ProductListContract.Presenter presenter;

    @BindView(R.id.product_list_recyclerview)
    RecyclerView mCategoryRecyclerView;

    ProductListAdapter mListAdapter;

    String mCategoryId;
    String mCategoryName;

    LinearLayoutManager layoutManager;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    public static void startInstance(Context context, String categoryId, String categoryName) {
        Intent intent = new Intent(context, ProductListActivity.class);

        Bundle extras = new Bundle();
        extras.putString(ARGS_CAT_ID, categoryId);
        extras.putString(ARGS_CAT_NAME, categoryName);
        intent.putExtras(extras);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
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
        presenter.requestProducts(mCategoryId, 20);
    }

    @Override
    public void setProductList(ArrayList<Product> products) {
        layoutManager = new LinearLayoutManager(this);
        mCategoryRecyclerView.setLayoutManager(layoutManager);
        mCategoryRecyclerView.setHasFixedSize(false);
        mCategoryRecyclerView.setNestedScrollingEnabled(false);
        mListAdapter = new ProductListAdapter(this, products);
//        mListAdapter.setOnItemClickListener((view, sipUserModel, position) -> {
//            presenter.requestLogin(sipUserModel, PackageUtils.getVersion(this), getString(R.string.HEADER_CHANNEL));
//        });
        mCategoryRecyclerView.setAdapter(mListAdapter);
        mCategoryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) //check for scroll down
                {
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            presenter.updateProducts(mCategoryId, mListAdapter.getItemCount());
                        }
                    }
                }
            }
        });
    }

    @Override
    public void updateProductList(ArrayList<Product> categoryItems) {
        mListAdapter.setmProductList(categoryItems);
        mListAdapter.notifyDataSetChanged();
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
        new SimpleConfirmationDialog(this).show(getString(R.string.error_dialog_title), getString(R.string.error_dialog_message), (dialog, which) -> {
            presenter.requestProducts(mCategoryId, 20);
        });
    }
}
