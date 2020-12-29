package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.dal.dao.*;

public class DaoFactory {

    public static CategoryDao getCategoryDao() {return new CategoryDaoJdbcImpl();}

    public static CustomerDao getCustomerDao() {return new CustomerDaoJdbcImpl();}

    public static EmployeeDao getEmployeeDao() {return new EmployeeDaoJdbcImpl();}

    public static OrderDao getOrderDao() {return new OrderDaoJdbcImpl();}

    public static OrderDetailsDao getOrderDetailsDao() {return new OrderDetailsDaoJdbcImpl();}

    public static ProductDao getProducDao() {return new ProductDaoJdbcImpl();}

    public static ShipperDao getShipperDao() {return new ShipperDaoJdbcImpl();}

    public static SupplierDao getSupplierDao() {return new SupplierDaoJdbcImpl();}

}
