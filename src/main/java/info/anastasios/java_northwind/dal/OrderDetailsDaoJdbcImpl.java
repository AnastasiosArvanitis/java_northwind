package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Order_details;
import info.anastasios.java_northwind.dal.dao.OrderDetailsDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDaoJdbcImpl implements OrderDetailsDao {
    @Override
    public List<Order_details> selectAllOrderDetails() throws SQLException, DAOException {
        return null;
    }
}
