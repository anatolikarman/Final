<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 15.02.2019
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please press "Find All" to load all user data</title>
</head>
<body background="pattern.jpg">
<div align="center">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <a href="FrontController?command=FIND_ALL">View List</a>


    <table border="1" width="300" cellpadding="5">

        <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Login</th>
            <th>Password</th>
            <th>Registration Date</th>
            <th>Role Id</th>
        </tr>
        <c:forEach items="${listUser}" var="element">

            <tr>
                <td>
                    <p>${element.userId}</p>
                </td>
                <td>
                    <p>${element.name}</p>
                </td>
                <td>
                    <p>${element.surname}</p>
                </td>
                <td>
                    <p>${element.login}</p>
                </td>
                <td>
                    <p>${element.password}</p>
                </td>
                <td>
                    <p>${element.registrationDate}</p>
                </td>
                <td>
                    <p>${element.roleId}</p>
                </td>

            </tr>
        </c:forEach>
    </table>

</div>
>
</body>
</html>
