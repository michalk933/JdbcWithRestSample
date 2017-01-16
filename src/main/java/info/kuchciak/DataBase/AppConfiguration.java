package info.kuchciak.DataBase;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "info.kuchciak")
public class AppConfiguration {


    //Connecting data base MySQL
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/classicmodels?useSSL=false");
        dataSource.setUser("test");
        dataSource.setPassword("test");
        return dataSource;
    }

    //Create new JdbcTemplate to do query
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
