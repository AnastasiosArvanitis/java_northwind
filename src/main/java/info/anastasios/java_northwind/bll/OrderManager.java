package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Order;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.OrderDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderManager {

    private static OrderManager instance;
    private OrderDao orderDao;

    private Logger logger = MyLogger.getLogger("OrderManager");

    private OrderManager() {
        orderDao = DaoFactory.getOrderDao();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            return new OrderManager();
        }
        return instance;
    }

    public List<Order> getOrders() throws SQLException, DAOException {
        List<Order> orders = new ArrayList<>();
        try {
            orders = orderDao.selectAllOrders();
        } catch (SQLException e) {
            logger.severe("Error method getOrders " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return orders;
    }

    public Order getOrderById(int orderId) throws SQLException, DAOException {
        Order order = null;
        try {
            order = orderDao.selectOrderById(orderId);
        } catch (SQLException e) {
            logger.severe("Error method getOrderById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return order;
    }

}




















