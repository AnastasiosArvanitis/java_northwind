package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Supplier;
import info.anastasios.java_northwind.dal.dao.SupplierDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class SupplierDaoJdbcImpl implements SupplierDao {
    @Override
    public List<Supplier> selectAllSuppliers() throws SQLException, DAOException {
        return null;
    }
}
