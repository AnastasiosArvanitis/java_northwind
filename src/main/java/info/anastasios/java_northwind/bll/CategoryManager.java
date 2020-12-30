package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.Category;
import info.anastasios.java_northwind.dal.DaoFactory;
import info.anastasios.java_northwind.dal.dao.CategoryDao;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CategoryManager {

    private static CategoryManager instance;
    private CategoryDao categoryDao;

    private Logger logger = MyLogger.getLogger("CategoryManager");

    private CategoryManager() {
        categoryDao = DaoFactory.getCategoryDao();
    }

    public static CategoryManager getInstance() {
        if (instance == null) {
            return new CategoryManager();
        }
        return instance;
    }

    public List<Category> getCategories() throws SQLException, DAOException {
        List<Category> categories = new ArrayList<>();
        try {
            categories = categoryDao.selectAllCategories();
        } catch (SQLException e) {
            logger.severe("Error method getCategories " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return categories;
    }

    public Category getCategoryById(int categoryId) throws SQLException, DAOException {
        Category category = null;
        try {
            category = categoryDao.selectCategoryById(categoryId);
        } catch (SQLException e) {
            logger.severe("Error method getCategoryById " + e.getMessage() + "\n");
            throw new DAOException(e.getMessage(), e);
        }
        return category;
    }

}

















