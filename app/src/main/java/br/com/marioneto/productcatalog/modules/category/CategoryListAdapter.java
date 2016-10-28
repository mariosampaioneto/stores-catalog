package br.com.marioneto.productcatalog.modules.category;

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
import br.com.marioneto.productcatalog.core.model.CategoryItem;
import br.com.marioneto.productcatalog.core.model.Parcel;
import br.com.marioneto.productcatalog.core.model.Product;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario_1a on 27/10/16.
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<CategoryItem> mCategoryList;
    private OnItemClickListener mItemClickListener;

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.category_list_item_name)
        TextView mCategoryName;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(view -> {
                if (mItemClickListener != null) {
                    int position = getAdapterPosition();
                    mItemClickListener.onItemClick(v, mCategoryList.get(position), position);
                }
            });
        }

        public void bind(CategoryItem categoryItem) {
            mCategoryName.setText(categoryItem.getName());
        }
    }

    public CategoryListAdapter(Context context, ArrayList<CategoryItem> categoryItems) {
        mContext = context;
        mCategoryList = categoryItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mCategoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public ArrayList<CategoryItem> getCategoryList() {
        return mCategoryList;
    }

    public void setmCategoryList(ArrayList<CategoryItem> mCategoryList) {
        this.mCategoryList = mCategoryList;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, CategoryItem categoryItem, int position);
    }
}
