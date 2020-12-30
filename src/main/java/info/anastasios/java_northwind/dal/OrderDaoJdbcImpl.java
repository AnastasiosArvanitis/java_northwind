package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.bo.Employee;
import info.anastasios.java_northwind.bo.Order;
import info.anastasios.java_northwind.bo.Shipper;
import info.anastasios.java_northwind.dal.dao.CustomerDao;
import info.anastasios.java_northwind.dal.dao.EmployeeDao;
import info.anastasios.java_northwind.dal.dao.OrderDao;
import info.anastasios.java_northwind.dal.dao.ShipperDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderDaoJdbcImpl  implements OrderDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("OrderDaoJdbcImpl");

    @Override
    public List<Order> selectAllOrders() throws SQLException, DAOException {
        List<Order> orders = new ArrayList<>();
        final String sqlQuery = "select * from Orders";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                orders.add(orderBuilder(resultSet));
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllOrders... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orders;
    }

    @Override
    public Order selectOrderById(int orderId) throws SQLException, DAOException {
        Order order = null;
        final String sqlQuery = "select * from Orders where OrderID=?";

        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = orderBuilder(resultSet);
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectOrderById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return order;
    }

    private Order orderBuilder(ResultSet rs) throws SQLException, DAOException {
        Customer orderCustomer = this.getOrderCustomer(rs.getString("CustomerID"));
        Employee orderEmployee = this.getOrderEmployee(rs.getInt("EmployeeID"));
        Shipper orderShipper = this.getOrderShipper(rs.getInt("ShipVia"));
        Order order = new Order();
        order.setOrderId(rs.getInt("OrderID"));
        order.setCustomer(orderCustomer);
        order.setEmployee(orderEmployee);
        order.setOrderDate(rs.getDate("OrderDate"));
        order.setRequiredDate(rs.getDate("RequiredDate"));
        order.setShippedDate(rs.getDate("ShippedDate"));
        order.setShipper(orderShipper);
        order.setFreight(rs.getDouble("Freight"));
        order.setShipName(rs.getString("ShipName"));
        order.setShipAddress(rs.getString("ShipAddress"));
        order.setShipCity(rs.getString("ShipCity"));
        order.setShipRegion(rs.getString("ShipRegion"));
        order.setShipPostalCode(rs.getString("ShipPostalCode"));
        order.setShipCountry(rs.getString("ShipCountry"));

        return order;
    }

    private Customer getOrderCustomer(String customerId) throws SQLException, DAOException {
        CustomerDao customerDao = DaoFactory.getCustomerDao();
        Customer orderCustomer = null;
        try {
            orderCustomer = customerDao.selectCustomerById(customerId);
        } catch (SQLException e) {
            logger.severe("Error getOrderCustomer... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderCustomer;
    }

    private Employee getOrderEmployee(int employeeId) throws SQLException, DAOException {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee orderEmployee = null;
        try {
            orderEmployee = employeeDao.selectEmployeeById(employeeId);
        } catch (SQLException e) {
            logger.severe("Error getOrderEmployee... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderEmployee;
    }

    private Shipper getOrderShipper(int shipperId) throws SQLException, DAOException {
        ShipperDao shipperDao = DaoFactory.getShipperDao();
        Shipper orderShipper = null;
        try {
            orderShipper = shipperDao.selectShipperById(shipperId);
        } catch (SQLException e) {
            logger.severe("Error getOrderShipper... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return orderShipper;
    }

}





