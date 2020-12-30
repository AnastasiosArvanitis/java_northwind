package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Shipper;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.ShipperDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShipperManager {

    private static ShipperManager instance;
    private ShipperDao shipperDao;

    private Logger logger = MyLogger.getLogger("ShipperManager");

    private ShipperManager() {
        shipperDao = DaoFactory.getShipperDao();
    }

    public static ShipperManager getInstance() {
        if (instance == null) {
            return new ShipperManager();
        }
        return instance;
    }

    public List<Shipper> getShippers() throws SQLException, DAOException {
        List<Shipper> shippers = new ArrayList<>();
        try {
            shippers = shipperDao.selectAllShippers();
        } catch (SQLException e) {
            logger.severe("Error method getShippers " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return shippers;
    }

    public Shipper getShipperById(int shipperId) throws SQLException, DAOException {
        Shipper shipper = null;
        try {
            shipper = shipperDao.selectShipperById(shipperId);
        } catch (SQLException e) {
            logger.severe("Error method getShipperById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return shipper;
    }

}



















