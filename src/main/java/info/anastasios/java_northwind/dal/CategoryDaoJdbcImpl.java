package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Category;
import info.anastasios.java_northwind.dal.dao.CategoryDao;
import info.anastasios.java_northwind.dal.jdbcTools.ConnectionManager;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CategoryDaoJdbcImpl implements CategoryDao {

    private Connection connection = null;
    private static Logger logger = MyLogger.getLogger("CategoryDaoJdbcImpl");

    @Override
    public List<Category> selectAllCategories() throws SQLException, DAOException {
        List<Category> categories = new ArrayList<>();
        final String sqlQuery = "select * from Categories";

        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                categories.add(categoryBuilder(resultSet));
            }
            ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllCategories... " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return categories;
    }


    @Override
    public Category selectCategoryById(int categoryId) throws SQLException, DAOException {
        Category category = null;
        final String sqlQuery = "select * from Categories where CategoryID=?";
        try {
            connection = ConnectionManager.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = categoryBuilder(resultSet);
            }
            ConnectionManager.disconnect();
        } catch (SQLException e) {
            logger.severe("Error selectAllCategoryById... " + e.getMessage() + "\n");
           throw new DAOException( e.getMessage(), e);
        }
        return category;
    }



    private Category categoryBuilder(ResultSet rs) throws SQLException, DAOException {
        Category category = new Category();
        category.setCategoryId(rs.getInt("CategoryId"));
        category.setCategoryName(rs.getString("CategoryName"));
        category.setDescription(rs.getString("Description"));

        return category;
    }

}





























