package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Order_details;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDao {

    List<Order_details> selectAllOrderDetails() throws SQLException, DAOException;

}
