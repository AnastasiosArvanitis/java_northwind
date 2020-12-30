package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Order_details;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.OrderDetailsDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderDetailsManager {

    private static OrderDetailsManager instance;
    private OrderDetailsDao orderDetailsDao;

    private Logger logger = MyLogger.getLogger("OrderDetailsManager");

    private OrderDetailsManager() {
        orderDetailsDao = DaoFactory.getOrderDetailsDao();
    }

    public static OrderDetailsManager getInstance() {
        if (instance == null) {
            return new OrderDetailsManager();
        }
        return instance;
    }

    public List<Order_details> getOrderDetails() throws SQLException, DAOException {
        List<Order_details> orderDetails = new ArrayList<>();
        try {
            orderDetails = orderDetailsDao.selectAllOrderDetails();
        } catch (SQLException e) {
            logger.severe("Error method getOrderDetails " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return orderDetails;
    }


}














