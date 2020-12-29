package info.anastasios.java_northwind.dal.dao;

import info.anastasios.java_northwind.bo.Category;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    List<Category> selectAllCategories() throws SQLException, DAOException;

}
