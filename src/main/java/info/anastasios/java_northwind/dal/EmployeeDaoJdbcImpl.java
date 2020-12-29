package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Employee;
import info.anastasios.java_northwind.dal.dao.EmployeeDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
    @Override
    public List<Employee> selectAllEmployees() throws SQLException, DAOException {
        return null;
    }
}
