package info.kuchciak.DataBase;

import java.math.BigDecimal;

/**
 * Created by michal on 16.01.2017.
 */
public interface ProductsBuilder {

    public void setProductCode(String productCode);
    public void setProductName(String productName);
    public void setProductLine(String productLine);
    public void setProductScale(String productScale);
    public void setProductVendor(String productVendor);
    public void setProductDescription(String productDescription);
    public void setQuantityInStock(int quantityInStock);
    public void setBuyPrice(BigDecimal buyPrice);
    public void setMSRP(BigDecimal MSRP);




}
