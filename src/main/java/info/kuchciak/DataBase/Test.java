package info.kuchciak.DataBase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Map;

// Class test
// Check connect with data base
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        Map<String, Object> product = productsRepository.getProduct("S10_4698");

        System.out.println("Mamy to : " + product);

        Products sample = productsRepository.getProductsByProductCode("S10_2016");
        System.out.println(sample);

        Products products = new Products();
        products.setProductCode("700-2049");
        products.setProductName("Cebula");
        products.setProductLine("Cebula");
        products.setProductScale("Cebula");
        products.setProductVendor("Cebula");
        products.setProductDescription("Cebula");
        products.setQuantityInStock(10);
        products.setBuyPrice(BigDecimal.valueOf(123.45));
        products.setMSRP(BigDecimal.valueOf(34.56));

        productsRepository.addNewProduct(products);

    }


}
