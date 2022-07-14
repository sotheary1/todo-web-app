package org.todo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.todo.model.todo.Todo;
import org.todo.model.user.User;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/todoList") // used to specify on url
public class TodoListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            request.setAttribute("todos", user.getTodoList().getTodos());
            request.getRequestDispatcher("todoList.jsp").forward(request, response); // call the file jsp
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        if (category.isEmpty()) category = null;
        String param = request.getParameter("dueDate");
        LocalDate dueDate = param.isEmpty() ? null : LocalDate.parse(param);
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            user.getTodoList().addTodo(new Todo(title, category, dueDate));
            doGet(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}