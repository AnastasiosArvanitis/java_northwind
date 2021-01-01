package info.anastasios.java_northwind.servlets;

import info.anastasios.java_northwind.bll.CustomerManager;
import info.anastasios.java_northwind.bo.Customer;
import info.anastasios.java_northwind.tools.DAOException;
import info.anastasios.java_northwind.tools.MyLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CustomersServlet extends HttpServlet {

    private CustomerManager customerManager = null;

    private Logger logger = MyLogger.getLogger("CustomerServlet");

    @Override
    public void init() throws ServletException {
        super.init();
        customerManager = CustomerManager.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        try {
            customers = customerManager.getCustomers();
        } catch (SQLException | DAOException e) {
            logger.severe("Error CustomersServlet " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        if (customers != null) {
            request.setAttribute("customers", customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Customers.jsp");
            dispatcher.forward(request, response);
        }
    }
}
