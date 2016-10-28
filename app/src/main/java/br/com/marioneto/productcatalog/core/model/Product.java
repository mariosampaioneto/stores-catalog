package br.com.marioneto.productcatalog.core.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

import br.com.marioneto.productcatalog.core.model.base.BaseModel;
import br.com.marioneto.productcatalog.core.util.StringFormatUtils;

/**
 * Created by mario_1a on 26/10/16.
 */

@Root(strict = false)
public class Product extends BaseModel {

    @Attribute
    private String prodId;

    @Attribute
    private String name;

    @Attribute
    private String price;

    @Attribute
    private String image;

    @ElementList(inline = true, required = false)
    @Path("paymentOptions")
    private List<PaymentOption> paymentOptions;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return StringFormatUtils.parseHtml(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return StringFormatUtils.parseHtml(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //
//
//    protected static final String INSTALLMENT_FORMAT_STRING = "%sx de %s sem juros";
//    public static final String SKU_DEFAULT = "DEFAULT";
//    @Attribute(required = false)
//    private String badgeImage;
//    @Attribute(required = false)
//    private String billetDiscountPercent;
//    @Attribute(required = false)
//    private String billetPrice;
//    //    private Money billetPriceMoney;
//    @Attribute(required = false)
//    private String brandDiscountPercent;
//    @Attribute(required = false)
//    private String brandDiscountedInstallment;
//    //    private Money brandDiscountedInstallmentMoney;
//    @Attribute(required = false)
//    private String brandDiscountedInstallmentPercent;
//    @Attribute(required = false)
//    private String brandPrice;
//    //    private Money brandPriceMoney;
//    @Attribute(required = false)
//    private String brand_installment;
//    @Element(name = "crossSell", required = false)
////    private CrossSell crossSell;
//    @Attribute(required = false)
//    private String description;
//    @Attribute(required = false)
//    private String discountedInstallment;
//    //    private Money discountedInstallmentMoney;
//    private int flagType;
//    //    @JsonProperty("image")
//    @Attribute(required = false)
//    private String image;
//    @Attribute(required = false)
//    private String installment;
//    //    @JsonProperty("installment_total")
//    private String installmentTotal;
//    //    @JsonProperty("installment_value")
//    private String installmentValue;
//    @Attribute(required = false)
//    private Boolean isWhiteLine = Boolean.valueOf(false);
//    private String lastSeenOnTv;
//    //    private FashionSkuList mFashionSkuList = new FashionSkuList();
//    @Element(name = "marketplace", required = false)
////    private Marketplace marketPlaceInfo;
//    @Attribute(required = false)
//    private String mqImage;
//    //    @JsonProperty("name")
//    @Attribute(required = false)
//    private String name;
//    //    @JsonProperty("reviews_count")
//    @Attribute(required = false)
//    private String numReviews;
//    @Attribute(required = false)
//    protected String partnerId;
//    @Attribute(required = false)
//    protected String partnerName;
//    @ElementList(inline = true, required = false)
//    @Path("paymentOptions")
////    private List<PaymentOption> paymentOptionList;
//    private String percent;
//    //    @JsonProperty("sales_price")
//    @Attribute(required = false)
//    private String price;
//    //    private Money priceDiscountMoney;
//    private String priceDiscountPercent;
//    //    @JsonProperty("default_price")
//    @Attribute(required = false)
//    private String priceFrom;
//    //    protected Money priceFromMoney;
////    protected Money priceMoney;
////    @JsonProperty("product_id")
//    @Attribute(required = false)
//    private String prodId;
//    //    @JsonProperty("rating_overall_average")
//    @Attribute(required = false)
//    private String rating;
//    private String recommendationClickUrl = "";
//    //    @ElementList(inline=true, required=false)
////    @Path("skuInfo")
////    private List<SkuDiff> skuDiffList;
////    @JsonProperty("skus")
//    @ElementList(inline = true, required = false)
//    @Path("skus")
////    private List<Sku> skuList;
////    @ElementList(inline=true, required=false)
////    private List<SpecTecs> specTecsList;
//    private boolean statusChanged;
//    //    @JsonProperty("stock")
//    @Attribute(required = false)
//    private Boolean stock = Boolean.valueOf(true);
//    //    private List<SpecTec> summarySpecTec = new ArrayList();
//    @ElementList(inline = true, required = false)
//    @Path("images")
////    private List<ThumbImage> thumbImageList;
////    private Money totalBilletDiscountMoney;
//    private String totalBilletDiscountPercent;
//    private String unescapedDescription = null;
//    private String unescapedName = null;
//    //    @JsonProperty("url")
//    @Attribute(required = false)
//    private String url;
//    @Attribute(required = false)
//    private String video;
//    private String wishlistDiscountPercent;
//
//    public static String getInstallmentFormatString() {
//        return INSTALLMENT_FORMAT_STRING;
//    }
//
//    public static String getSkuDefault() {
//        return SKU_DEFAULT;
//    }
//
//    public String getBadgeImage() {
//        return badgeImage;
//    }
//
//    public void setBadgeImage(String badgeImage) {
//        this.badgeImage = badgeImage;
//    }
//
//    public String getBilletDiscountPercent() {
//        return billetDiscountPercent;
//    }
//
//    public void setBilletDiscountPercent(String billetDiscountPercent) {
//        this.billetDiscountPercent = billetDiscountPercent;
//    }
//
//    public String getBilletPrice() {
//        return billetPrice;
//    }
//
//    public void setBilletPrice(String billetPrice) {
//        this.billetPrice = billetPrice;
//    }
//
//    public String getBrandDiscountPercent() {
//        return brandDiscountPercent;
//    }
//
//    public void setBrandDiscountPercent(String brandDiscountPercent) {
//        this.brandDiscountPercent = brandDiscountPercent;
//    }
//
//    public String getBrandDiscountedInstallment() {
//        return brandDiscountedInstallment;
//    }
//
//    public void setBrandDiscountedInstallment(String brandDiscountedInstallment) {
//        this.brandDiscountedInstallment = brandDiscountedInstallment;
//    }
//
//    public String getBrandDiscountedInstallmentPercent() {
//        return brandDiscountedInstallmentPercent;
//    }
//
//    public void setBrandDiscountedInstallmentPercent(String brandDiscountedInstallmentPercent) {
//        this.brandDiscountedInstallmentPercent = brandDiscountedInstallmentPercent;
//    }
//
//    public String getBrandPrice() {
//        return brandPrice;
//    }
//
//    public void setBrandPrice(String brandPrice) {
//        this.brandPrice = brandPrice;
//    }
//
//    public String getBrand_installment() {
//        return brand_installment;
//    }
//
//    public void setBrand_installment(String brand_installment) {
//        this.brand_installment = brand_installment;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDiscountedInstallment() {
//        return discountedInstallment;
//    }
//
//    public void setDiscountedInstallment(String discountedInstallment) {
//        this.discountedInstallment = discountedInstallment;
//    }
//
//    public int getFlagType() {
//        return flagType;
//    }
//
//    public void setFlagType(int flagType) {
//        this.flagType = flagType;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getInstallment() {
//        return installment;
//    }
//
//    public void setInstallment(String installment) {
//        this.installment = installment;
//    }
//
//    public String getInstallmentTotal() {
//        return installmentTotal;
//    }
//
//    public void setInstallmentTotal(String installmentTotal) {
//        this.installmentTotal = installmentTotal;
//    }
//
//    public String getInstallmentValue() {
//        return installmentValue;
//    }
//
//    public void setInstallmentValue(String installmentValue) {
//        this.installmentValue = installmentValue;
//    }
//
//    public Boolean getWhiteLine() {
//        return isWhiteLine;
//    }
//
//    public void setWhiteLine(Boolean whiteLine) {
//        isWhiteLine = whiteLine;
//    }
//
//    public String getLastSeenOnTv() {
//        return lastSeenOnTv;
//    }
//
//    public void setLastSeenOnTv(String lastSeenOnTv) {
//        this.lastSeenOnTv = lastSeenOnTv;
//    }
//
//    public String getMqImage() {
//        return mqImage;
//    }
//
//    public void setMqImage(String mqImage) {
//        this.mqImage = mqImage;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNumReviews() {
//        return numReviews;
//    }
//
//    public void setNumReviews(String numReviews) {
//        this.numReviews = numReviews;
//    }
//
//    public String getPartnerId() {
//        return partnerId;
//    }
//
//    public void setPartnerId(String partnerId) {
//        this.partnerId = partnerId;
//    }
//
//    public String getPartnerName() {
//        return partnerName;
//    }
//
//    public void setPartnerName(String partnerName) {
//        this.partnerName = partnerName;
//    }
//
//    public String getPercent() {
//        return percent;
//    }
//
//    public void setPercent(String percent) {
//        this.percent = percent;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getPriceDiscountPercent() {
//        return priceDiscountPercent;
//    }
//
//    public void setPriceDiscountPercent(String priceDiscountPercent) {
//        this.priceDiscountPercent = priceDiscountPercent;
//    }
//
//    public String getPriceFrom() {
//        return priceFrom;
//    }
//
//    public void setPriceFrom(String priceFrom) {
//        this.priceFrom = priceFrom;
//    }
//
//    public String getProdId() {
//        return prodId;
//    }
//
//    public void setProdId(String prodId) {
//        this.prodId = prodId;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }
//
//    public String getRecommendationClickUrl() {
//        return recommendationClickUrl;
//    }
//
//    public void setRecommendationClickUrl(String recommendationClickUrl) {
//        this.recommendationClickUrl = recommendationClickUrl;
//    }
//
//    public boolean isStatusChanged() {
//        return statusChanged;
//    }
//
//    public void setStatusChanged(boolean statusChanged) {
//        this.statusChanged = statusChanged;
//    }
//
//    public Boolean getStock() {
//        return stock;
//    }
//
//    public void setStock(Boolean stock) {
//        this.stock = stock;
//    }
//
//    public String getTotalBilletDiscountPercent() {
//        return totalBilletDiscountPercent;
//    }
//
//    public void setTotalBilletDiscountPercent(String totalBilletDiscountPercent) {
//        this.totalBilletDiscountPercent = totalBilletDiscountPercent;
//    }
//
//    public String getUnescapedDescription() {
//        return unescapedDescription;
//    }
//
//    public void setUnescapedDescription(String unescapedDescription) {
//        this.unescapedDescription = unescapedDescription;
//    }
//
//    public String getUnescapedName() {
//        return unescapedName;
//    }
//
//    public void setUnescapedName(String unescapedName) {
//        this.unescapedName = unescapedName;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getVideo() {
//        return video;
//    }
//
//    public void setVideo(String video) {
//        this.video = video;
//    }
//
//    public String getWishlistDiscountPercent() {
//        return wishlistDiscountPercent;
//    }
//
//    public void setWishlistDiscountPercent(String wishlistDiscountPercent) {
//        this.wishlistDiscountPercent = wishlistDiscountPercent;
//    }
}
