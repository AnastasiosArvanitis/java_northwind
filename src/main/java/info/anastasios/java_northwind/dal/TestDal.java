package info.anastasios.java_northwind.dal;

import info.anastasios.java_northwind.bo.*;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDal {

    public static void main(String[] args) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = DaoFactory.getCustomerDao().selectAllCustomers();
        } catch (SQLException | DAOException e) {
            throw new SQLException(e.getMessage());
        }

        for (Customer i : customers) {
            System.out.println(i);
        }

        System.out.println();

        Customer c1 = new Customer();
        try {
            c1 = DaoFactory.getCustomerDao().selectCustomerById("TRADH");
            System.out.println(c1.toString());
        } catch (SQLException | DAOException e) {
            throw new SQLException(e.getMessage());
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Category> categories = new ArrayList<>();
        try {
            categories = DaoFactory.getCategoryDao().selectAllCategories();
        } catch (SQLException | DAOException e) {
            throw new SQLException(e.getMessage());
        }

        for (Category i : categories) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Employee> employees = new ArrayList<>();
        try {
            employees = DaoFactory.getEmployeeDao().selectAllEmployees();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (Employee j : employees) {
            System.out.println(j);
        }

        System.out.println();

        Employee employee = new Employee();
        try {
            employee = DaoFactory.getEmployeeDao().selectEmployeeById(3);
            System.out.println(employee.toString());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Supplier> suppliers = new ArrayList<>();
        try {
            suppliers = DaoFactory.getSupplierDao().selectAllSuppliers();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (Supplier k : suppliers) {
            System.out.println(k);
        }
        System.out.println();

        Supplier s1 = new Supplier();
        try {
            s1 = DaoFactory.getSupplierDao().selectSupplierById(21);
            System.out.println(s1.toString());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Shipper> shippers = new ArrayList<>();
        try {
            shippers = DaoFactory.getShipperDao().selectAllShippers();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (Shipper l : shippers) {
            System.out.println(l);
        }
        System.out.println();

        Shipper sh1 = new Shipper();
        try {
            sh1 = DaoFactory.getShipperDao().selectShipperById(2);
            System.out.println(sh1.toString());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Product> products = new ArrayList<>();
        try {
            products = DaoFactory.getProducDao().selectAllProducts();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println();

        Product p1 = new Product();
        try {
            p1 = DaoFactory.getProducDao().selectProductById(2);
            System.out.println(p1.toString());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        List<Order> orders = new ArrayList<>();
        try {
            orders = DaoFactory.getOrderDao().selectAllOrders();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (Order o : orders) {
            System.out.println(o);
        }

        System.out.println();

        Order o1 = new Order();
        try {
            o1 = DaoFactory.getOrderDao().selectOrderById(10933);
            System.out.println(o1.toString());
        } catch (DAOException e) {
            e.printStackTrace();
        }


    }

}















