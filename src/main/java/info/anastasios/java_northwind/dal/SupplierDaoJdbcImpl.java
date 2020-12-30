package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Supplier;
import info.anastasios.java_northwind.dal.dao.SupplierDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SupplierDaoJdbcImpl implements SupplierDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("SupplierDaoJdbcImpl");

    @Override
    public List<Supplier> selectAllSuppliers() throws SQLException, DAOException {
        List<Supplier> suppliers = new ArrayList<>();
        final String sqlQuery = "select * from Suppliers";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                suppliers.add(supplierBuilder(resultSet));
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllSuppliers... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return suppliers;
    }

    @Override
    public Supplier selectSupplierById(int supplierId) throws SQLException, DAOException {
        Supplier supplier = null;
        final String sqlQuery = "select * from Suppliers where SupplierID=?";

        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, supplierId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                supplier = supplierBuilder(resultSet);
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectSupplierById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return supplier;
    }

    private Supplier supplierBuilder(ResultSet rs) throws SQLException, DAOException {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(rs.getInt("SupplierID"));
        supplier.setCompanyName(rs.getString("CompanyName"));
        supplier.setContactName(rs.getString("ContactName"));
        supplier.setContactTitle(rs.getString("ContactTitle"));
        supplier.setAddress(rs.getString("Address"));
        supplier.setCity(rs.getString("City"));
        supplier.setRegion(rs.getString("Region"));
        supplier.setPostalCode(rs.getString("PostalCode"));
        supplier.setCountry(rs.getString("Country"));
        supplier.setPhone(rs.getString("Phone"));
        supplier.setFax(rs.getString("Fax"));
        supplier.setHomePage(rs.getString("Homepage"));

        return supplier;
    }
}



























