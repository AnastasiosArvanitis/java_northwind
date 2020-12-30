package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Order;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    List<Order> selectAllOrders() throws SQLException, DAOException;

    Order selectOrderById(int orderId) throws SQLException, DAOException;

}
