<%@ page import="info.anastasios.java_northwind.bo.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <style>
        <%@ include file="./styles/_global.css"%>
    </style>

</head>
<body>

<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>

<div class="container-fluid my-container">
    <h1>Northwind database</h1>
    <h2>List of all the customers</h2>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>CustomerId</th>
            <th>CompanyName</th>
            <th>ContactName</th>
            <th>ContactTitle</th>
            <th>Address</th>
            <th>City</th>
            <th>Region</th>
            <th>PostalCode</th>
            <th>Country</th>
            <th>Phone</th>
            <th>Fax</th>
        </tr>
        </thead>
        <tbody>
        <% for (Customer c : customers) { %>
        <tr>
            <td><%=c.getCustomerId()%></td>
            <td><%=c.getCompanyName()%></td>
            <td><%=c.getContactName()%></td>
            <td><%=c.getContactTitle()%></td>
            <td><%=c.getAddress()%></td>
            <td><%=c.getCity()%></td>
            <td><%=c.getRegion()%></td>
            <td><%=c.getPostalCode()%></td>
            <td><%=c.getCountry()%></td>
            <td><%=c.getPhone()%></td>
            <td><%=c.getFax()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>

</div>

</body>
</html>
