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
<c:if test="${not empty user}">
    <h1>${user.name}'s Todo List</h1>
    <c:forEach items="${todos}" var="todo">
        <div class="todo">
            <b>${todo.title}</b><br>
            Category: ${todo.category}<br>
            Due Date: ${todo.dueDate}
        </div>
    </c:forEach>
    <br>
    <a href="todo.jsp">New Todo</a>
    <br><br>
    <form action="userAdmin" method="post">
        <button name="action" type="submit" value="logout">Logout</button>
    </form>
</c:if>
<c:if test="${empty user}">
    <c:redirect url="login.jsp"/>
</c:if>
</body>
</html>