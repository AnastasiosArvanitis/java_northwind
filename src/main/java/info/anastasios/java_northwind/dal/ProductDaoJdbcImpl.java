package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Category;
import info.anastasios.java_northwind.bo.Product;
import info.anastasios.java_northwind.bo.Supplier;
import info.anastasios.java_northwind.dal.dao.CategoryDao;
import info.anastasios.java_northwind.dal.dao.ProductDao;
import info.anastasios.java_northwind.dal.dao.SupplierDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductDaoJdbcImpl implements ProductDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("ProductDaoJdbcImpl");

    @Override
    public List<Product> selectAllProducts() throws SQLException, DAOException {
        List<Product> products = new ArrayList<>();
        final String sqlQuery = "select * from Products";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                products.add(productBuilder(resultSet));
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllProducts... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return products;
    }


    @Override
    public Product selectProductById(int productId) throws SQLException, DAOException {
        Product product = null;
        final String sqlQuery = "select * from Products where ProductID=?";

        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = productBuilder(resultSet);
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectProductById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return product;
    }

    private Product productBuilder(ResultSet rs) throws SQLException, DAOException {
        Category productCategory = this.getProductCategory(rs.getInt("CategoryID"));
        Supplier productSupplier = this.getProductSupplier(rs.getInt("SupplierID"));
        Product product = new Product();
        product.setProductId(rs.getInt("ProductID"));
        product.setProductName(rs.getString("ProductName"));
        product.setSupplier(productSupplier);
        product.setCategory(productCategory);
        product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
        product.setUnitPrice(rs.getDouble("UnitPrice"));
        product.setUnitsInStock(rs.getInt("UnitsInStock"));
        product.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
        product.setReorderLevel(rs.getInt("ReorderLevel"));
        product.setDiscontinued(rs.getBoolean("Discontinued"));

        return product;
    }

    private Category getProductCategory(int categoryId) throws SQLException, DAOException {
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        Category productCategory = null;
        try {
            productCategory = categoryDao.selectCategoryById(categoryId);
        } catch (SQLException e) {
            logger.severe("Error getProductCategory... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return productCategory;
    }

    private Supplier getProductSupplier(int supplierId) throws SQLException, DAOException {
        SupplierDao supplierDao = DaoFactory.getSupplierDao();
        Supplier productSupplier = null;
        try {
            productSupplier = supplierDao.selectSupplierById(supplierId);
        } catch (SQLException e) {
            logger.severe("Error getProductSupplier... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return productSupplier;
    }

}


















