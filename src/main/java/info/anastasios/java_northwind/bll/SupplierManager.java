package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Supplier;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.SupplierDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SupplierManager {

    private static SupplierManager instance;
    private SupplierDao supplierDao;

    private Logger logger = MyLogger.getLogger("SupplierManager");

    private SupplierManager() {
        supplierDao = DaoFactory.getSupplierDao();
    }

    public static SupplierManager getInstance() {
        if (instance == null) {
            return new SupplierManager();
        }
        return instance;
    }

    public List<Supplier> getSuppliers() throws SQLException, DAOException {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            suppliers = supplierDao.selectAllSuppliers();
        } catch (SQLException e) {
            logger.severe("Error method getSuppliers " +e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return suppliers;
    }

    public Supplier getSupplierById(int supplierId) throws SQLException, DAOException {
        Supplier supplier = null;
        try {
            supplier = supplierDao.selectSupplierById(supplierId);
        } catch (SQLException e) {
            logger.severe("Error method getSupplierById " +e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return supplier;
    }

}




















