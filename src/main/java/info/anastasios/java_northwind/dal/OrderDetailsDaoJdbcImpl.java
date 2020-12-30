package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Order;
import info.anastasios.java_northwind.bo.Order_details;
import info.anastasios.java_northwind.bo.Product;
import info.anastasios.java_northwind.dal.dao.OrderDao;
import info.anastasios.java_northwind.dal.dao.OrderDetailsDao;
import info.anastasios.java_northwind.dal.dao.ProductDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderDetailsDaoJdbcImpl implements OrderDetailsDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("OrderDetailsDaoJdbcImpl");

    @Override
    public List<Order_details> selectAllOrderDetails() throws SQLException, DAOException {
        List<Order_details> orderDetails = new ArrayList<>();
        final String sqlQuery = "select * from [Order Details]";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                orderDetails.add(orderDetailsBuilder(resultSet));
            }
        } catch (SQLException e) {
            logger.severe("Error selectAllOrderDetails... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderDetails;
    }

    private Order_details orderDetailsBuilder(ResultSet rs) throws SQLException, DAOException {
        Order orderDetailsOrder = this.getOrderDetailsOrder(rs.getInt("OrderID"));
        Product orderDetailsProduct = this.getOrderDetailsProduct(rs.getInt("ProductID"));
        Order_details orderDetails = new Order_details();
        orderDetails.setOrder(orderDetailsOrder);
        orderDetails.setProduct(orderDetailsProduct);
        orderDetails.setUnitPrice(rs.getDouble("UnitPrice"));
        orderDetails.setQuantity(rs.getInt("Quantity"));
        orderDetails.setDiscount(rs.getDouble("Discount"));

        return orderDetails;
    }

    private Order getOrderDetailsOrder(int orderId) throws SQLException, DAOException {
        OrderDao orderDao = DaoFactory.getOrderDao();
        Order orderDetailsOrder = null;
        try {
            orderDetailsOrder = orderDao.selectOrderById(orderId);
        } catch (SQLException e) {
            logger.severe("Error getOrderDetailsOrder... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderDetailsOrder;
    }

    private Product getOrderDetailsProduct(int productId) throws SQLException, DAOException {
        ProductDao productDao = DaoFactory.getProducDao();
        Product orderDetailsProduct = null;
        try {
            orderDetailsProduct = productDao.selectProductById(productId);
        }catch (SQLException e) {
            logger.severe("Error getOrderDetailsProduct... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderDetailsProduct;
    }
}

















