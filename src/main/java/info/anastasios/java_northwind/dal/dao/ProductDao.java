package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Product;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> selectAllProducts() throws SQLException, DAOException;

    Product selectProductById(int productId) throws SQLException, DAOException;

}
