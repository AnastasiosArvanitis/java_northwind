package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.Category;
import info.anastasios.java_northwind.dal.dao.CategoryDao;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoJdbcImpl implements CategoryDao {
    @Override
    public List<Category> selectAllCategories() throws SQLException, DAOException {
        return null;
    }
}
