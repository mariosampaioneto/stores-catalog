package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "data", strict = false)
public class CategoryList extends BaseModel {

    @Attribute(required = false)
    String title;

    @ElementList(inline = true)
    protected List<Category> categoryList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
