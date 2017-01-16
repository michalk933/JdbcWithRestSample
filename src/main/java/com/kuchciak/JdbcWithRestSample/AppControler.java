package com.kuchciak.JdbcWithRestSample;

import info.kuchciak.DataBase.AppConfiguration;
import info.kuchciak.DataBase.Products;
import info.kuchciak.DataBase.ProductsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Controler REST
// Return result query url adress
@RestController
public class AppControler {


    // Return object Products with productCode = S10_2016
    @RequestMapping("getEmp")
    public List<Products> EmployList() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        Products sample = productsRepository.getProductsByProductCode("S10_2016");
        List<Products> productses = new ArrayList<>();
        productses.add(sample);

        return productses;

    }


}
