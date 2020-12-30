package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Shipper;
import info.anastasios.java_northwind.dal.dao.ShipperDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShipperDaoJdbcImpl implements ShipperDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("ShipperDaoJdbcImpl");

    @Override
    public List<Shipper> selectAllShippers() throws SQLException, DAOException {
        List<Shipper> shippers = new ArrayList<>();
        final String sqlQuery = "select * from Shippers";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                shippers.add(shipperBuilder(resultSet));
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllShippers... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return shippers;
    }

    @Override
    public Shipper selectShipperById(int shipperId) throws SQLException, DAOException {
        Shipper shipper = null;
        final String sqlQuery = "select * from Shippers where ShipperID=?";

        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, shipperId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shipper = shipperBuilder(resultSet);
            }
            //ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectShipperById... " + e.getMessage() + "\n");
            throw new DAOException( e.getMessage(), e);
        }
        return shipper;
    }

    private Shipper shipperBuilder(ResultSet rs) throws SQLException, DAOException {
        Shipper shipper = new Shipper();
        shipper.setShipperId(rs.getInt("ShipperID"));
        shipper.setCompanyName(rs.getString("CompanyName"));
        shipper.setPhone(rs.getString("Phone"));

        return shipper;
    }

}















