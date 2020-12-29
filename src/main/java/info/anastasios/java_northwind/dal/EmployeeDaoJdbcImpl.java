package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Employee;
import info.anastasios.java_northwind.dal.dao.EmployeeDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("EmployeeDaoJdbcImpl");

    @Override
    public List<Employee> selectAllEmployees() throws SQLException, DAOException {
        List<Employee> employees = new ArrayList<>();
        final String sqlQuery = "select * from Employees";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                employees.add(employeeBuilder(resultSet));
            }
            ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllCategoryById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return employees;
    }


    @Override
    public Employee selectEmployeeById(int employeeId) throws SQLException, DAOException {
        Employee employee = null;
        final String sqlQuery = "select * from Employees where EmployeeID=?";

        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = employeeBuilder(resultSet);
            }
            ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllCategoryById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return employee;
    }

    private Employee employeeBuilder(ResultSet rs) throws SQLException, DAOException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("EmployeeID"));
        employee.setLastName(rs.getString("LastName"));
        employee.setFirstName(rs.getString("FirstName"));
        employee.setTitle(rs.getString("Title"));
        employee.setTitleOfCourtesy(rs.getString("TitleOfCourtesy"));
        employee.setBirthDate(rs.getDate("Birthdate"));
        employee.setHireDate(rs.getDate("HireDate"));
        employee.setAddress(rs.getString("Address"));
        employee.setCity(rs.getString("City"));
        employee.setRegion(rs.getString("Region"));
        employee.setPostalCode(rs.getString("PostalCode"));
        employee.setCountry(rs.getString("Country"));
        employee.setHomePhone(rs.getString("HomePhone"));
        employee.setExtension(rs.getString("Extension"));
        employee.setNotes(rs.getString("Notes"));

        return employee;
    }
}




















