package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Employee;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    List<Employee> selectAllEmployees() throws SQLException, DAOException;

    Employee selectEmployeeById(int employeeId) throws SQLException, DAOException;

}
