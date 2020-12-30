package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Employee;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.EmployeeDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeManager {

    private static EmployeeManager instance;
    private EmployeeDao employeeDao;

    private Logger logger = MyLogger.getLogger("EmployeeManager");

    private EmployeeManager() {
        employeeDao = DaoFactory.getEmployeeDao();
    }

    public static EmployeeManager getInstance() {
        if (instance == null) {
            return new EmployeeManager();
        }
        return instance;
    }

    public List<Employee> getEmployees() throws SQLException, DAOException {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = employeeDao.selectAllEmployees();
        } catch (SQLException e) {
            logger.severe("Error method getEmployees " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return employees;
    }

    public Employee getEmployeeById(int employeeId) throws SQLException, DAOException{
        Employee employee = null;
        try {
            employee = employeeDao.selectEmployeeById(employeeId);
        } catch (SQLException e) {
            logger.severe("Error method getCustomerById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return employee;
    }

}





















