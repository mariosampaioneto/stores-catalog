package br.com.marioneto.productcatalog.modules.category;

import android.content.DialogInterface;
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
import br.com.marioneto.productcatalog.modules.base.BaseFragment;
import br.com.marioneto.productcatalog.modules.subcategory.SubCategoryListActivity;
import br.com.marioneto.productcatalog.modules.widget.custom.dialog.SimpleConfirmationDialog;
import br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal.ProductsHorizontalList;
import br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal.ProductsHorizontalListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 28/10/16.
 */

public class CategoryListFragment extends BaseFragment implements CategoryListContract.View {

    public static final String ARGS_CAT_ID = "ARGS_CAT_ID";

    @Inject
    CategoryListContract.Presenter presenter;

    @BindView(R.id.category_list_recyclerview)
    RecyclerView mCategoryRecyclerView;

    CategoryListAdapter mListAdapter;

    String mCategoryId;

    public CategoryListFragment() {
        // Required empty public constructor
    }

    public static CategoryListFragment newInstance(String categoryId) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_CAT_ID, categoryId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        getFragmentComponent().inject(this);
        ButterKnife.bind(this, view);

        loadArgs();
        init();

        return view;
    }

    private void loadArgs() {
        if (getArguments().containsKey(ARGS_CAT_ID)) {
            mCategoryId = getArguments().getString(ARGS_CAT_ID);
        }
    }

    private void init() {
        presenter.bindView(this);
        presenter.requestCategory(mCategoryId);
    }

    @Override
    public void setCategoryList(ArrayList<CategoryItem> categoryItems) {
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryRecyclerView.setHasFixedSize(false);
        mCategoryRecyclerView.setNestedScrollingEnabled(false);
        mListAdapter = new CategoryListAdapter(getContext(), categoryItems);
        mListAdapter.setOnItemClickListener((view, categoryItem, position) -> {
            SubCategoryListActivity.startInstance(getContext(), categoryItem.getMenuId(), categoryItem.getName());
        });
        mCategoryRecyclerView.setAdapter(mListAdapter);
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
            presenter.requestCategory(mCategoryId);
        });
    }
}
