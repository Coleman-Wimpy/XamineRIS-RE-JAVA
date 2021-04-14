package com.example.XamineRIS_RE_JAVA.radiologist;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import com.example.XamineRIS_RE_JAVA.patient.PatientsInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "radiologistServlet", value = "/radiologist")
public class radiologistServlet extends HttpServlet implements OrderInterface, PatientsInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Document> orders = getWaitingOrders();
        String result = "";

        for(int i = orders.size()-1; i >= 0; i--) {
            int orderNum = orders.get(i).getInteger("orderNumber");
            String firstName = orders.get(i).getString("firstName");
            String lastName = orders.get(i).getString("lastName");
            String dob = orders.get(i).getString("DOB");
            String modality = orders.get(i).getString("modality");
            result += "<form action=\"/OrderRadioPage\" method=\"POST\"><p>" + orderNum + " - " + firstName + " " + lastName + " | Date of Birth: " + dob + " Modality: " + modality + "</p> <button type=\"sumbit\" name=\"btn\" value=\"" + orderNum + "\" > View</button></form>";
        }

        request.setAttribute("orders", result);
        getServletContext().getRequestDispatcher("/radiologist/patientRadiologistSearch.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
