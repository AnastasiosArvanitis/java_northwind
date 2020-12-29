package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Order;
import info.anastasios.java_northwind.dal.dao.OrderDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoJdbcImpl  implements OrderDao {
    @Override
    public List<Order> selectAllOrders() throws SQLException, DAOException {
        return null;
    }
}
