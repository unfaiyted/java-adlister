package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;


@WebServlet(name = "controllers.AdCategoriesJSONServlet", urlPatterns = "/ad/getCat")
public class AdCategoriesJSONServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String json;

       if(request.getParameter("id") == null|| request.getParameter("id").isEmpty() ) {
           json = new Gson().toJson(DaoFactory.getAdCategoryDao().main());

       } else {
           Long id = Long.parseLong(request.getParameter("id"));
           json = new Gson().toJson(DaoFactory.getAdCategoryDao().sub(id));
       }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }


}



