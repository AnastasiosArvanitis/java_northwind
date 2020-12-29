package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Supplier;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDao {

    List<Supplier> selectAllSuppliers() throws SQLException, DAOException;

}
