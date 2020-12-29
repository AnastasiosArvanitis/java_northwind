package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.dal.dao.CustomerDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoJdbcImpl implements CustomerDao {
    @Override
    public List<Customer> selectAllCustomers() throws SQLException, DAOException {
        return null;
    }
}
