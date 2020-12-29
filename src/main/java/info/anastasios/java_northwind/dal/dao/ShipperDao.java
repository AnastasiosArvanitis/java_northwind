package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Shipper;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface ShipperDao {

    List<Shipper> selectAllShippers() throws SQLException, DAOException;

}
