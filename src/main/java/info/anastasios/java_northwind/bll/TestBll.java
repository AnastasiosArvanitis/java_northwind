package info.anastasios.java_northwind.bll;

import info.anastasios.java_northwind.bo.*;
import info.anastasios.java_northwind.tools.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestBll {

    public static void main(String[] args) throws SQLException, DAOException {
/*
        List<Customer> customers = CustomerManager.getInstance().getCustomers();
        for (Customer c : customers) {
            System.out.println(c);
        }
        System.out.println();

        Customer c1 = CustomerManager.getInstance().getCustomerById("THEBI");
        System.out.println(c1.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Category> categories = CategoryManager.getInstance().getCategories();
        for (Category cat : categories) {
            System.out.println(cat);
        }
        System.out.println();

        Category category = CategoryManager.getInstance().getCategoryById(5);
        System.out.println(category.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Employee> employees = EmployeeManager.getInstance().getEmployees();
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();

        Employee e1 = EmployeeManager.getInstance().getEmployeeById(6);
        System.out.println(e1.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Supplier> suppliers = SupplierManager.getInstance().getSuppliers();
        for (Supplier s : suppliers) {
            System.out.println(s);
        }
        System.out.println();

        Supplier s1 = SupplierManager.getInstance().getSupplierById(28);
        System.out.println(s1.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Shipper> shippers = ShipperManager.getInstance().getShippers();
        for (Shipper sh : shippers) {
            System.out.println(sh);
        }
        System.out.println();

        Shipper sh1 = ShipperManager.getInstance().getShipperById(3);
        System.out.println(sh1.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Product> products = ProductManager.getInstance().getProducts();
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println();

        Product p1 = ProductManager.getInstance().getProductById(76);
        System.out.println(p1.toString());

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Order> orders = OrderManager.getInstance().getOrders();
        for (Order o : orders) {
            System.out.println(o);
        }
        System.out.println();

        Order oo = OrderManager.getInstance().getOrderById(11010);
        System.out.println(oo.toString()); */

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        List<Order_details> orderDetails = OrderDetailsManager.getInstance().getOrderDetails();
        for (Order_details od : orderDetails) {
            System.out.println(od);
        }

    }

}















