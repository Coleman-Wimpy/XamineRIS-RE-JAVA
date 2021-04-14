package com.example.XamineRIS_RE_JAVA.technician;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "imageTechViewServlet", value = "/imageTechView")
public class imageTechViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("btn");
        System.out.println(path);

        request.setAttribute("path", path);
        getServletContext().getRequestDispatcher("/technician/imageTechView.jsp").forward(request, response);
    }
}
