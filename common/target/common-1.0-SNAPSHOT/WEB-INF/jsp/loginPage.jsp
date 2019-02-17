<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16.02.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body background="pattern.jpg">
<div align="center">
    <form action="FrontController" method="post">
        <input type="hidden" name="command" value="AUTHORISE">
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
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <input type="submit" value="login"/>

        <!-- <input type="hidden" name="command" value="registration">
         <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
         <input type="password" id="Password" name="password" size="20" maxlength="25" placeholder="Password">
         <input type="submit" id="finish_button" value="Login">-->
    </form>

</div>
</body>
</html>
