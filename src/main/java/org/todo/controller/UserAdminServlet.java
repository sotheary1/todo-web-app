package org.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.todo.model.user.InvalidCredentialsException;
import org.todo.model.user.User;
import org.todo.model.user.UserAdmin;
import org.todo.model.user.UserAlreadyExistsException;

import java.io.IOException;

@WebServlet("/userAdmin")
public class UserAdminServlet extends HttpServlet {

    private static final UserAdmin userAdmin = UserAdmin.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            switch (action) {
                case "register":
                    user = userAdmin.registerUser(username, password);
                    break;
                case "login":
                    user = userAdmin.loginUser(username, password);
                    break;
                case "logout":
                    request.getSession().invalidate();
            }
        } catch (InvalidCredentialsException ex) {
            request.setAttribute("message", "Invalid name or password");
        } catch (UserAlreadyExistsException ex) {
            request.setAttribute("message", "User already exists");
        }
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "todoList");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}