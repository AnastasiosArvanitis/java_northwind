package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Product;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.ProductDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductManager {

    private static ProductManager instance;
    private ProductDao productDao;

    private Logger logger = MyLogger.getLogger("ProductManager");

    private ProductManager() {
        productDao = DaoFactory.getProducDao();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            return new ProductManager();
        }
        return instance;
    }

    public List<Product> getProducts() throws SQLException, DAOException {
        List<Product> products = new ArrayList<>();
        try {
            products = productDao.selectAllProducts();
        } catch (SQLException e) {
            logger.severe("Error method getProducts " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return products;
    }

    public Product getProductById(int productId) throws SQLException, DAOException {
        Product product = null;
        try {
            product = productDao.selectProductById(productId);
        } catch (SQLException e) {
            logger.severe("Error method getProductById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return product;
    }

}



















