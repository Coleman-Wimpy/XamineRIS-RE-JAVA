package com.example.XamineRIS_RE_JAVA.order;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "com.example.XamineRIS_RE_JAVA.order.orderCheckInServlet", value = "/OrderReceptPage/checkin")
public class orderCheckInServlet extends HttpServlet implements OrderInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderNum = Integer.parseInt(request.getParameter("btn"));

        updateOrderStatus("Checked In", orderNum);

        ArrayList<Document> orderDoc = getOrder(orderNum);

        if (orderDoc != null) {
            request.setAttribute("orderNum", orderNum);
            request.setAttribute("status", orderDoc.get(0).getString("status"));
            request.setAttribute("firstName", orderDoc.get(0).getString("firstName"));
            request.setAttribute("lastName", orderDoc.get(0).getString("lastName"));
            request.setAttribute("reason", orderDoc.get(0).getString("reason"));
            request.setAttribute("imaging", orderDoc.get(0).getString("imaging"));
            request.setAttribute("modality", orderDoc.get(0).getString("modality"));
            request.setAttribute("orderNotes", orderDoc.get(0).getString("orderNotes"));
        }

        getServletContext().getRequestDispatcher("/orderReceptPage.jsp").forward(request, response);
    }
}
