package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "data", strict = false)
public class HighlightItemList extends BaseModel {
    @ElementList(inline = true)
    protected List<ProductList> highlightItemList;

    public List<ProductList> getHighlightItemList() {
        return highlightItemList;
    }
}
