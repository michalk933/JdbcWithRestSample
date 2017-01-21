package com.kuchciak.JdbcWithRestSample;

import info.kuchciak.DataBase.AppConfiguration;
import info.kuchciak.DataBase.Products;
import info.kuchciak.DataBase.ProductsRepository;
import info.kuchciak.DataBase.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Controler REST
// Return result query url adress
@RestController
public class AppControler {


    // Return object Products with productCode = S10_2016
    @GetMapping("getEmp")
    public List<Products> EmployList() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        Products sample = productsRepository.getProductsByProductCode("S10_2016");
        List<Products> productses = new ArrayList<>();
        productses.add(sample);


        return productses;

    }

    // Methoad get data from user.
    // Create new object Products and send to Repository
    //productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP
    @PostMapping("addProduct/")
    public String addProduct(@RequestParam("productCode") String productCode,
                             @RequestParam("productName") String productName,
                             @RequestParam("productLine") String productLine,
                             @RequestParam("productScale") String productScale,
                             @RequestParam("productVendor") String productVendor,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("quantityInStock") int quantityInStock,
                             @RequestParam("buyPrice") double buyPrice,
                             @RequestParam("MSRP") double MSRP) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = applicationContext.getBean("productsRepository", ProductsRepository.class);

        Products products = new Products();
        products.setProductCode(productCode);
        products.setProductName(productName);
        products.setProductLine(productLine);
        products.setProductScale(productScale);
        products.setProductVendor(productVendor);
        products.setProductDescription(productDescription);
        products.setQuantityInStock(quantityInStock);
        products.setBuyPrice(BigDecimal.valueOf(buyPrice));
        products.setMSRP(BigDecimal.valueOf(MSRP));

        String result = productsRepository.addNewProduct(products);

        return result + products.toString();
    }
//'S700_2047', 'HMS Bounty', 'Ships', '1:700', 'Unimax Art Galleries', 'Measures 30 inches Long x 27 1/2 inches High x 4 3/4 inches Wide. \r\nMany extras including rigging, long boats, pilot house, anchors, etc. Comes with three masts, all square-rigged.', '3501', '39.83', '90.52'

    @PostMapping("sellProdukt/{productName}/quantity/{quantityInStock}")
    public String sellProduktQuantity(@PathVariable String productName,
                                    @PathVariable int quantityInStock) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = applicationContext.getBean("productsRepository", ProductsRepository.class);

        int result = productsRepository.sellOneProduct(productName, quantityInStock);
        return (result > 10) ? ("Stan magazynu : " + result) : ("Niski stan magazynu : " + result);
    }

    //String productName, int quantityInStock

//'
}
