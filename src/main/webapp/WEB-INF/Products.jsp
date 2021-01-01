<%@ page import="java.util.List" %>
<%@ page import="info.anastasios.java_northwind.bo.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <style>
        <%@ include file="./styles/_global.css"%>
    </style>
</head>
<body>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>

<div class="container-fluid my-container">
    <h1>Northwind database</h1>
    <h2>List of all the customers</h2>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Quantity Per Unit</th>
            <th>Unit Price</th>
            <th>Units In Stock</th>
            <th>Units On Order</th>
            <th>Reorder Level</th>
            <th>Category Id</th>
            <th>Category Name</th>
            <th>Category Description</th>
            <th>Supplier Id</th>
            <th>Company Name</th>
            <th>Contact Name</th>
            <th>Country</th>
        </tr>
        </thead>
        <tbody>
            <% for (Product p : products) { %>
                <tr>
                    <td><%=p.getProductId()%></td>
                    <td><%=p.getProductName()%></td>
                    <td><%=p.getQuantityPerUnit()%></td>
                    <td><%=p.getUnitPrice()%></td>
                    <td><%=p.getUnitsInStock()%></td>
                    <td><%=p.getUnitsOnOrder()%></td>
                    <td><%=p.getReorderLevel()%></td>
                    <td><%=p.getCategory().getCategoryId()%></td>
                    <td><%=p.getCategory().getCategoryName()%></td>
                    <td><%=p.getCategory().getDescription()%></td>
                    <td><%=p.getSupplier().getSupplierId()%></td>
                    <td><%=p.getSupplier().getCompanyName()%></td>
                    <td><%=p.getSupplier().getContactName()%></td>
                    <td><%=p.getSupplier().getCountry()%></td>
                </tr>
            <%}%>
        </tbody>
    </table>

</div>
</body>
</html>
