package br.com.marioneto.productcatalog.modules.widget.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public abstract class CustomFrameLayout extends FrameLayout {

    public CustomFrameLayout(Context context) {
        super(context);
        onCreateView(context, null, 0);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreateView(context, attrs, 0);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreateView(context, attrs, defStyleAttr);
    }

    public abstract void onCreateView(Context context, AttributeSet attrs, int defStyleAttr);

    protected View setContentView(Context context, @LayoutRes int id) {
        View view = inflate(context, id);
        addView(view);
        return view;
    }

    protected View inflate(Context context, @LayoutRes int resource) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, null);
    }

    protected AppCompatActivity getActivity() {
        Context c = getContext();
        if (c != null && c instanceof AppCompatActivity) {
            return (AppCompatActivity) c;
        }
        return null;
    }

    protected String getString(@StringRes int id) {
        return getResources().getString(id);
    }

}
