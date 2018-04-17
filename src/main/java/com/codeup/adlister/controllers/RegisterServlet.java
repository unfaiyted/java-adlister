package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        // ensure the submitted information is valid
        Boolean error = false;
        String  message = "";

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");

        //User tempUser = new User(0, username, email, password);
        if(DaoFactory.getUsersDao().findByUsername(username) != null) {
            error = true;
            message += "<p>Username taken.</p>";
        }
        if(username.trim().length() <= 0 || username.isEmpty() ) {
            error = true;
            message += "<p>Username is empty</p>";
        }

        if(email.isEmpty() || !emailValidate(email)) {
            error = true;
            message += "<p>Email is not formatted properly</p>";
        }

        if(!password.equals(passwordConfirm) || password.isEmpty()) {
            error = true;
            message += "<p>Passwords do not match or are empty</p>";
        }

        if (error) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            // TODO: create a new user based off of the submitted information

            DaoFactory.getUsersDao().insert(new User(0, username, email, password));

            // TODO: if a user was successfully created, send them to their profile;


            response.sendRedirect("/profile");

        }

       // request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }



//    private boolean validateUser(User user) {
//
//    }



    public static boolean emailValidate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

}
