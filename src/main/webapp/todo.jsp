<%--
  Created by IntelliJ IDEA.
  User: ssoth
  Date: 14.07.2022
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DOCTYPE html-->

<html>
<head>
    <meta charset="utf-8">
    <title>Todo App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">

</head>
<body>
<h1>New Todo</h1>
<form action="todoList" method="post">
    <label>Title*</label>
    <input name="title" required>
    <label>Category</label>
    <input name="category">
    <label>Due Date</label>
    <input name="dueDate" type="date">
    <button type="submit">Add Todo</button>
</form>
<br><br>
<a href="todoList">Cancel</a>
</body>
</html>