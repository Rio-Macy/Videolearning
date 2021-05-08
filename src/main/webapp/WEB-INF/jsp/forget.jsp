<%--
  Created by IntelliJ IDEA.
  User: sujuntao
  Date: 2021/4/18
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<body>
    <h1>密码找回</h1>
    <form action="/findPwd" method="post">
        邮箱：<input type="text" name="email">

        <input type="submit">
    </form>
</body>
</html>
