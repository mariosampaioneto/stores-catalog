package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "parent", strict = false)
public class Category extends BaseModel {
    @ElementList(inline = true)
    ArrayList<CategoryItem> menuItemList;
    @Attribute(required = false)
    private String name;

    public ArrayList<CategoryItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<CategoryItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
