package info.anastasios.java_northwind.servlets;

import info.anastasios.java_northwind.bll.ProductManager;
import info.anastasios.java_northwind.bo.Product;
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


public class ProductsServlet extends HttpServlet {

    private ProductManager productManager = null;

    private Logger logger = MyLogger.getLogger("ProductsServlet");

    @Override
    public void init() throws ServletException {
        super.init();
        productManager = ProductManager.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = null;
        try {
            products = productManager.getProducts();
        } catch (SQLException | DAOException e) {
            logger.severe("Error ProductsServlet " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        if (products != null) {
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Products.jsp");
            dispatcher.forward(request, response);
        }
    }
}
