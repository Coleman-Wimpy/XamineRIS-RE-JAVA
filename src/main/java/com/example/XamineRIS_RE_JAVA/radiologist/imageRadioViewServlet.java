package com.example.XamineRIS_RE_JAVA.radiologist;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "imageRadioViewServlet", value = "/imageRadioView")
public class imageRadioViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("btn");
        System.out.println(path);

        request.setAttribute("path", path);
        getServletContext().getRequestDispatcher("/radiologist/imageRadioView.jsp").forward(request, response);
    }
}
