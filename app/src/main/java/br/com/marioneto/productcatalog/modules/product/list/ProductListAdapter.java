package br.com.marioneto.productcatalog.modules.product.list;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.model.Parcel;
import br.com.marioneto.productcatalog.core.model.Product;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 27/10/16.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Product> mProductList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.prod_horz_list_item_img)
        ImageView mProcutImg;

        @BindView(R.id.prod_horz_list_item_title)
        TextView mProductTitle;

        @BindView(R.id.prod_horz_list_item_price)
        TextView mProductPrice;

        @BindView(R.id.prod_horz_list_item_payment)
        TextView mProductPayment;


        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
//            v.setOnClickListener(view -> {
//                if (mItemClickListener != null) {
//                    int position = getAdapterPosition();
//                    mItemClickListener.onItemClick(v, sipUserModelArrayList.get(position), position);
//                }
//            });
        }

        public void bind(Product product) {
            mProductTitle.setText(product.getName());
            mProductPrice.setText(product.getPrice());

            if (product.getPaymentOptions() != null && product.getPaymentOptions().isEmpty()) {
                mProductPayment.setVisibility(View.INVISIBLE);
            } else {
                if (product.getPaymentOptions() != null && product.getPaymentOptions().get(0) != null) {
                    ArrayList<Parcel> parcels = product.getPaymentOptions().get(0).getParcels();
                    mProductPayment.setText(parcels.get(parcels.size() - 1).getValue());
                } else {
                    mProductPayment.setVisibility(View.INVISIBLE);
                }
            }

            if (TextUtils.isEmpty(product.getImage())) {
                //TODO could use a prettier holder if urls is empty or image fails to load
            } else {
                Picasso.with(mContext)
                        .load(Uri.parse(product.getImage()))
                        .into(mProcutImg);
            }
        }
    }

    public ProductListAdapter(Context context, ArrayList<Product> sipUsers) {
        mContext = context;
        mProductList = sipUsers;
    }

    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_prdct_vertical, parent, false);
        return new ProductListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.ViewHolder holder, int position) {
        holder.bind(mProductList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public ArrayList<Product> getmProductList() {
        return mProductList;
    }

    public void setmProductList(ArrayList<Product> mProductList) {
        this.mProductList = mProductList;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
