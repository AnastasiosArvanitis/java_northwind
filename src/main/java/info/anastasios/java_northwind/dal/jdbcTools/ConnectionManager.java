package info.anastasios.java_northwind.dal.jdbcTools;

import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionManager {

    private static final String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=NORTHWND";
    private static final String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dbUser = "sa";
    private static final String dbPassword = "flox123";
    private static final String jdbcInterceptors = "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
            "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer";

    private static DataSource dataSource = new DataSource();
    private static Connection connection;

    private static Logger logger = MyLogger.getLogger("ConnectionManager");

    static {
        PoolProperties poolProps = new PoolProperties();
        poolProps.setUrl(dbUrl);
        poolProps.setDriverClassName(dbDriver);
        poolProps.setUsername(dbUser);
        poolProps.setPassword(dbPassword);
        poolProps.setMaxActive(100);
        poolProps.setInitialSize(10);
        poolProps.setMaxWait(10000);
        poolProps.setJdbcInterceptors(jdbcInterceptors);
        dataSource.setPoolProperties(poolProps);
    }

    public static Connection connect() throws DAOException, SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                logger.severe("Error jdbc connection driver not loaded... " + e.getMessage() + "\n");
                throw new DAOException(e.getMessage(), e);
            }
        }
        return connection;
    }

    public static void disconnect() throws DAOException, SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}




















