<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>index</title>
</head>
<body>
<button>
    <%=request.getAttribute("listUser")%>
</button>
</body>
<form action="FrontController" method="post">
    <input type="hidden" name="userId" value="${element.userId}">
    <input type="hidden" name="command" value="user_block">
    <input type="submit">
</form>



<a href="FrontController?command=test_command">View List </a>
</html>

