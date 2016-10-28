package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;

/**
 * Created by mario_1a on 27/10/16.
 */

@Root(name = "paymentOption", strict = false)
public class PaymentOption extends BaseModel {

    @ElementList(inline = true, required = false)
    private ArrayList<Parcel> parcels;

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(ArrayList<Parcel> parcels) {
        this.parcels = parcels;
    }
}
