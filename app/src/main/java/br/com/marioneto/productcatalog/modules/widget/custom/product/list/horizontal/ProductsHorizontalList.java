package br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.model.Product;
import br.com.marioneto.productcatalog.core.util.StringFormatUtils;
import br.com.marioneto.productcatalog.modules.widget.base.CustomFrameLayout;
import br.com.marioneto.productcatalog.modules.widget.base.CustomViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 27/10/16.
 */

public class ProductsHorizontalList extends CustomFrameLayout {

    Context mContext;

    ProductsHorizontalListAdapter mListAdapter;

    @BindView(R.id.widget_horiz_prod_list_image)
    ImageView mHighlightImageView;

    @BindView(R.id.widget_horiz_prod_list_title)
    TextView mTitleTextView;

    @BindView(R.id.widget_horiz_prod_list_desc)
    TextView mDescTextView;

    @BindView(R.id.widget_horiz_prod_list_recyclerview)
    RecyclerView mProductsRecyclerView;


    public ProductsHorizontalList(Context context) {
        super(context);
        this.mContext = context;
    }

    public ProductsHorizontalList(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public ProductsHorizontalList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    public void onCreateView(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = setContentView(context, R.layout.widget_horizontal_prod_list);
        ButterKnife.bind(this);
    }

    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            mTitleTextView.setVisibility(View.GONE);
        } else {
            mTitleTextView.setText(StringFormatUtils.parseHtml(title));
        }
    }

    public void setDescription(String description) {
        if (TextUtils.isEmpty(description)) {
            mDescTextView.setVisibility(View.GONE);
        } else {
            mDescTextView.setText(description);
        }
    }

    public void setImage(String imageUrl) {
        if (TextUtils.isEmpty(imageUrl)) {
            mHighlightImageView.setVisibility(View.GONE);
        } else {
            Picasso.with(mContext)
                    .load(Uri.parse(imageUrl))
                    .into(mHighlightImageView);
        }
    }

    public void setRecyclerView(RecyclerView.LayoutManager layoutManager, ArrayList<Product> productList) {
        mProductsRecyclerView.setLayoutManager(layoutManager);
        mProductsRecyclerView.setHasFixedSize(false);
        mProductsRecyclerView.setNestedScrollingEnabled(false);
        mListAdapter = new ProductsHorizontalListAdapter(mContext, productList);
//        mListAdapter.setOnItemClickListener((view, sipUserModel, position) -> {
//            presenter.requestLogin(sipUserModel, PackageUtils.getVersion(this), getString(R.string.HEADER_CHANNEL));
//        });
        mProductsRecyclerView.setAdapter(mListAdapter);
    }

    public void updateRecyclerView(ArrayList<Product> productList) {
        if (mListAdapter != null) {
            mListAdapter.setmProductList(productList);
            mListAdapter.notifyDataSetChanged();
        }
    }
}
