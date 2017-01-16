package info.kuchciak.DataBase;

import java.math.BigDecimal;

/**
 * Created by michal on 13.01.2017.
 */
public class Products implements ProductsBuilder {
    //productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;


    @Override
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Override
    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Override
    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Override
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }
}
