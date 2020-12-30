package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.CustomerDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerManager {

    private static CustomerManager instance;
    private CustomerDao customerDao;

    private Logger logger = MyLogger.getLogger("CustomerManager");

    private CustomerManager() {
        customerDao = DaoFactory.getCustomerDao();
    }

    public static CustomerManager getInstance() {
        if (instance == null) {
            return new CustomerManager();
        }
        return instance;
    }

    public List<Customer> getCustomers() throws SQLException, DAOException {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerDao.selectAllCustomers();
        } catch (SQLException e) {
            logger.severe("Error method getCustomers " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return customers;
    }

    public Customer getCustomerById(String customerId) throws SQLException, DAOException {
        Customer customer = null;
        try {
            customer = customerDao.selectCustomerById(customerId);
        }catch (SQLException e) {
            logger.severe("Error method getCustomerById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return customer;
    }


}



















