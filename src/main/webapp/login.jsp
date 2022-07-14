<%--
  Created by IntelliJ IDEA.
  User: ssoth
  Date: 14.07.2022
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Todo App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h1>Login</h1>
<form action="userAdmin" method="post">
    <label>Username*</label>
    <input name="username" required>
    <label>Password*</label>
    <input name="password" type="password" required>
    <button name="action" type="submit" value="login">Login</button>
    <button name="action" type="submit" value="register">Register</button>
</form>
<br><br>
<div class="error">${message}</div>
</body>
</html>
</html>