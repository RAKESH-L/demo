<%@ taglib uri="http://java.sum.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>view All Products</title>
    </head>
    <body>
        <h1>Product List</h1>
        <table border="2">
            <tr>
                <th>PRODUCT ID</th>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Brand</th>
                <th>Price</th>
            </tr>
            <tr>
                <c:forEach var="p" items="${list}">
                    <td>${p.productId}</td>
                    <td>${p.productName}</td>
                    <td>${p.description}</td>
                    <td>${p.Brand}</td>
                    <td>${p.price}</td>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>