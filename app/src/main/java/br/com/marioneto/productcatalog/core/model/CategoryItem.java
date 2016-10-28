package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;
import br.com.marioneto.productcatalog.core.util.StringFormatUtils;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "menuItem", strict = false)
public class CategoryItem extends BaseModel {
    @Attribute
    private String group;
    @Attribute(required = false)
    private boolean haveChildren = true;
    @Attribute
    private String menuId;
    @Attribute
    private String name;
    @Attribute(required = false)
    private String tag;
    private String unescapedName = null;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isHaveChildren() {
        return haveChildren;
    }

    public void setHaveChildren(boolean haveChildren) {
        this.haveChildren = haveChildren;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return StringFormatUtils.parseHtml(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUnescapedName() {
        return unescapedName;
    }

    public void setUnescapedName(String unescapedName) {
        this.unescapedName = unescapedName;
    }
}
