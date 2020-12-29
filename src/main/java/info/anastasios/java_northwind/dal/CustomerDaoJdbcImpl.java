package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.dal.dao.CustomerDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerDaoJdbcImpl implements CustomerDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("CustomerDaoJdbcImpl");

    @Override
    public List<Customer> selectAllCustomers() throws SQLException, DAOException {
        List<Customer> customers = new ArrayList<>();
        final String sqlQuery = "select * from Customers";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                customers.add(customerBuilder(resultSet));
            }
            ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllCustomers... " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }

        return customers;
    }

    @Override
    public Customer selectCustomerById(String customerId) throws SQLException, DAOException {
        Customer customer = null;
        final String sqlQuery = "select * from Customers where CustomerID=?";
        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = customerBuilder(resultSet);
            }
        } catch (SQLException e) {
            logger.severe("Error selectAllCategoryById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }

        return customer;
    }

    private Customer customerBuilder(ResultSet rs) throws SQLException, DAOException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getString("CustomerID"));
        customer.setCompanyName(rs.getString("CompanyName"));
        customer.setContactName(rs.getString("ContactName"));
        customer.setContactTitle(rs.getString("ContactTitle"));
        customer.setAddress(rs.getString("Address"));
        customer.setCity(rs.getString("City"));
        customer.setRegion(rs.getString("Region"));
        customer.setPostalCode(rs.getString("PostalCode"));
        customer.setCountry(rs.getString("Country"));
        customer.setPhone(rs.getString("Phone"));
        customer.setFax(rs.getString("Fax"));

        return customer;
    }

}
