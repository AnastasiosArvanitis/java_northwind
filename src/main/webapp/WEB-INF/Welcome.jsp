<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NorthWind</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <style>
        <%@ include file="./styles/_global.css"%>
    </style>

</head>

<body>
    <div class="container-fluid">
        <h1>Welcome to the NorthWind Database Application</h1>
        <div class="m-0">
            <p><a href="<%=request.getContextPath()%>/Customers">List all customers</a></p>
            <p><a href="<%=request.getContextPath()%>/Products">List all products</a></p>
        </div>
    </div>


</body>
</html>
