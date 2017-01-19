package info.kuchciak.DataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class ProductsRepository {

    private JdbcTemplate jdbcTemplate;

    //AppConfiguration have options ComponentScan and find jdbcTemplate
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // Methot test
    // Get and show one row
    public Map<String, Object> getProduct(String productCode) {
        String sql = "SELECT * FROM products WHERE productCode = ?";
        return jdbcTemplate.queryForMap(sql, productCode);
    }

    // Method mapping result query with data base in object Products
    // Get one row with productCode
    public Products getProductsByProductCode(String productCode) {
        RowMapper<Products> rowMapper = new RowMapper<Products>() {
            @Override
            public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
                Products products = new Products();
                products.setProductCode(rs.getString("productCode"));
                products.setProductName(rs.getString("productName"));
                products.setProductLine(rs.getString("productLine"));
                products.setProductScale(rs.getString("productScale"));
                products.setProductVendor(rs.getString("productVendor"));
                products.setProductDescription(rs.getString("productDescription"));
                products.setQuantityInStock(rs.getInt("quantityInStock"));
                products.setBuyPrice(rs.getBigDecimal("buyPrice"));
                products.setMSRP(rs.getBigDecimal("MSRP"));
                return products;
            }
        };
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE productCode = ?", rowMapper, productCode);
    }


    // Method add new record in to Products table 
    public void addNewProduct(Products products) {
        System.out.println(products.toString());
        String sql = "INSERT INTO products " + "(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{products.getProductCode(), products.getProductName(), products.getProductLine(),
                products.getProductScale(), products.getProductVendor(), products.getProductDescription(),
                products.getQuantityInStock(), products.getBuyPrice(), products.getMSRP()};

        int update = jdbcTemplate.update(sql, objects);
        System.out.println("Co zwraca baza : " + update);

    }

//localhost:8080/addProduct/?productCode=S800_8000&productName=Cebula&productLine=Ships&productScale=1:700&productVendor=Unimax&productDescription=CosTamCosTam&quantityInStock=99999&buyPrice=321.65&MSRP=66.66
}
