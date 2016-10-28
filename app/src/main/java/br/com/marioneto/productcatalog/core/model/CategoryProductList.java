package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 28/10/16.
 */

@Root(name = "data", strict = false)
public class CategoryProductList extends BaseModel {
    @ElementList(inline = true)
    protected ArrayList<Product> productList;

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
