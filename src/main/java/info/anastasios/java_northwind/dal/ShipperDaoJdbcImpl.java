package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Shipper;
import info.anastasios.java_northwind.dal.dao.ShipperDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class ShipperDaoJdbcImpl implements ShipperDao {
    @Override
    public List<Shipper> selectAllShippers() throws SQLException, DAOException {
        return null;
    }
}
