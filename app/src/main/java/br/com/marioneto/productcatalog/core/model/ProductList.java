package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;
import br.com.marioneto.productcatalog.core.util.StringFormatUtils;

/**
 * Created by mario_1a on 26/10/16.
 */

@Root(name = "list", strict = false)
public class ProductList extends BaseModel {

    @ElementList(inline = true, required = false)
    protected ArrayList<Product> list = new ArrayList<Product>();

    @Attribute(required = false)
    private String title;

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }

    public String getTitle() {
        return StringFormatUtils.parseHtml(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //
//    public void add(Product paramProduct) {
//        if (getProductList() == null) {
//            this.productList = new ArrayList();
//        }
//        this.productList.add(paramProduct);
//    }
//
//    public void addAll(ProductList paramProductList) {
//        getProductList().addAll(paramProductList.getProductList());
//    }
//
//    public void addAll(List<Product> paramList) {
//        getProductList().addAll(paramList);
//    }
//
//    public Product get(int paramInt) {
//        return (Product) getProductList().get(paramInt);
//    }
//
//    public ProductList getAllInStock() {
//        ProductList localProductList = new ProductList();
//        Iterator localIterator = getProductList().iterator();
//        while (localIterator.hasNext()) {
//            Product localProduct = (Product) localIterator.next();
////            if (localProduct.getStock().booleanValue()) {
////                localProductList.add(localProduct);
////            }
//        }
//        return localProductList;
//    }
//
//    public List<String> getProductIds() {
//        ArrayList localArrayList = new ArrayList();
//        Iterator localIterator = this.productList.iterator();
//        while (localIterator.hasNext()) {
////            localArrayList.add(((Product) localIterator.next()).getProdId());
//        }
//        return localArrayList;
//    }
//
//    public List<Product> getProductList() {
//        return this.productList;
//    }
//
//    public Boolean hasProducts() {
//        if ((this.productList != null) && (!this.productList.isEmpty())) {
//        }
//        for (boolean bool = true; ; bool = false) {
//            return Boolean.valueOf(bool);
//        }
//    }
//
//    public Boolean isSingleProduct() {
//        boolean bool2 = true;
//        boolean bool1 = bool2;
//        if (hasProducts().booleanValue()) {
//            if (this.productList.size() != 1) {
////                break label34;
//            }
//        }
//        label34:
//        for (bool1 = bool2; ; bool1 = false) {
//            return Boolean.valueOf(bool1);
//        }
//    }
//
//    public Iterator iterator() {
//        return getProductList().iterator();
//    }
//
//    public void setProductList(List<Product> paramList) {
//        this.productList = paramList;
//    }
//
//    public Product singleResult() {
//        if (!hasProducts().booleanValue()) {
//            return null;
//        }
//        return (Product) this.productList.get(0);
//    }
//
//    public int size() {
//        return getProductList().size();
//    }

//    public void sortProducts(List<String> paramList) {
//        Collections.sort(this.productList, Product.comparatorUsingIdOrder(paramList));
//    }
}
