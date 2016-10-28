package br.com.marioneto.productcatalog.modules.product.detail;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import javax.inject.Inject;

import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.modules.base.BaseActivity;
import br.com.marioneto.productcatalog.modules.widget.custom.product.list.horizontal.ProductsHorizontalList;

public class ProductDetailActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, ProductDetailContract.View {

    @Inject
    ProductDetailContract.Presenter presenter;

    ProductsHorizontalList mHighlightProductsHorizontalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init() {
        presenter.bindView(this);
        mHighlightProductsHorizontalList = (ProductsHorizontalList) findViewById(R.id.main_hor_product_view);
    }

//    @Override
//    public void setHighlightProductList(String listTitle, String listDesc, String listImageUrl, ArrayList<Product> highlightProductList) {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mHighlightProductsHorizontalList.setTitle(listTitle);
//        mHighlightProductsHorizontalList.setDescription(listDesc);
//        mHighlightProductsHorizontalList.setImage(listImageUrl);
//        mHighlightProductsHorizontalList.setRecyclerView(layoutManager, highlightProductList);
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_highlights) {
            // Handle the camera action
        } else if (id == R.id.nav_categories) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
