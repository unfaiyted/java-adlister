package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.AdCategoriesIndexServlet", urlPatterns = "/main")
public class AdCategoriesIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("main", DaoFactory.getAdCategoryDao().main());
        request.getRequestDispatcher("/WEB-INF/adCategories/index.jsp").forward(request, response);
    }

}



