package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    List<Customer> selectAllCustomers() throws SQLException, DAOException;

    Customer selectCustomerById(String customerId) throws SQLException, DAOException;

}
