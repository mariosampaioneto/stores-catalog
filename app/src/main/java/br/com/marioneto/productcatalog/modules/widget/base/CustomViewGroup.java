package br.com.marioneto.productcatalog.modules.widget.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewGroup extends ViewGroup {

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(l, t, r, b);
        }
    }

    protected View setContentView(Context context, @LayoutRes int id) {
        View view = inflate(context, id);
        addView(view);
        return view;
    }

    protected View inflate(Context context, @LayoutRes int resource) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, null);
    }

}
