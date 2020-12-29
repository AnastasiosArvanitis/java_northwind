package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Product;
import info.anastasios.java_northwind.dal.dao.ProductDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao {
    @Override
    public List<Product> selectAllProducts() throws SQLException, DAOException {
        return null;
    }
}
