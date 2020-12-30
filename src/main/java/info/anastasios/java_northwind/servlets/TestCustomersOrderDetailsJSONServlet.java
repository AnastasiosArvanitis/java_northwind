package info.anastasios.java_northwind.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import info.anastasios.java_northwind.bll.CustomerManager;
import info.anastasios.java_northwind.bll.OrderDetailsManager;
import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.bo.Order_details;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;


public class TestCustomersOrderDetailsJSONServlet extends HttpServlet {

    private CustomerManager customerManager = null;
    private OrderDetailsManager orderDetailsManager = null;

    private Logger logger = MyLogger.getLogger("TestCustomersOrderDetailsJSONServlet");

    @Override
    public void init() throws ServletException {
        super.init();
        customerManager = CustomerManager.getInstance();
        orderDetailsManager = OrderDetailsManager.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        List<Order_details> orderDetails = null;
        try {
            customers = customerManager.getCustomers();
            orderDetails = orderDetailsManager.getOrderDetails();
        } catch (SQLException | DAOException e) {
            logger.severe("Error WelcomeServlet " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        String jsonCustomers = new Gson().toJson(customers);
        String jsonOrderDetails = new Gson().toJson(orderDetails);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonCustomers);
        response.getWriter().write(jsonOrderDetails);
    }
}












