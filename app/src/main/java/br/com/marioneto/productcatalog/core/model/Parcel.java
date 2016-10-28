package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "parcel", strict = false)
public class Parcel extends BaseModel {

    @Attribute(required = false)
    private String interestRate;
    @Attribute(required = false)
    private String total;
    @Attribute(required = false)
    private String value;

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
