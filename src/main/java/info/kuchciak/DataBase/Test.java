package info.kuchciak.DataBase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Created by michal on 13.01.2017.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        Map<String, Object> product = productsRepository.getProduct("S10_4698");

        System.out.println("Mamy to : " + product);

        Products sample = productsRepository.getProductsByProductCode("S10_2016");
        System.out.println(sample);


    }
    //'S10_2016'

}
