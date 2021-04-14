package com.example.XamineRIS_RE_JAVA.radiologist;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "orderRadioPageServlet", value = "/OrderRadioPage")
public class orderRadioPageServlet extends HttpServlet implements OrderInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderNum = Integer.parseInt(request.getParameter("btn"));
        HttpSession session = request.getSession();
        session.setAttribute("orderNum", orderNum);

        ArrayList<Document> orders = getOrder(orderNum);

        if(orders != null) {
            request.setAttribute("orderNum", orderNum);
            request.setAttribute("firstName", orders.get(0).getString("firstName"));
            request.setAttribute("lastName", orders.get(0).getString("lastName"));
            request.setAttribute("reason", orders.get(0).getString("reason"));
            request.setAttribute("imaging", orders.get(0).getString("imaging"));
            request.setAttribute("modality", orders.get(0).getString("modality"));
            request.setAttribute("orderNotes", orders.get(0).getString("orderNotes"));
        }

        String patientName = orders.get(0).getString("firstName") + "_" + orders.get(0).getString("lastName");

        File images = new File("C:\\Users\\cwimp\\IdeaProjects\\XamineRIS-RE-JAVA\\src\\main\\webapp\\patientImages\\" + patientName);
        String contents[] = images.list();
        String imageList = "";

        for(int i = 0; i < contents.length; i++)
        {
            imageList += "<form method=\"POST\" action=\"/imageRadioView\">" + contents[i] + "<button type=\"submit\" name=\"btn\" value=\"/patientImages/" + patientName + "/" + contents[i] + "\">View</button></form><br>";
        }

        request.setAttribute("images", imageList);

        updateOrderStatus("Complete", orderNum);

        getServletContext().getRequestDispatcher("/radiologist/orderRadioPage.jsp").forward(request, response);
    }
}
