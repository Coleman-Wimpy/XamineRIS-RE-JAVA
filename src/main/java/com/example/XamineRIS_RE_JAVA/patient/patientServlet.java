package com.example.XamineRIS_RE_JAVA.patient;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "com.example.XamineRIS_RE_JAVA.patient.patientServlet", value = "/patientPortal")
public class patientServlet extends HttpServlet implements PatientsInterface, OrderInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = session.getAttribute("user").toString();

        ArrayList<Document> bDocuments = getPatient(username);

        if (bDocuments != null) {
            request.setAttribute("firstName", bDocuments.get(0).getString("firstName"));
            request.setAttribute("lastName", bDocuments.get(0).getString("lastName"));
            request.setAttribute("middleName", bDocuments.get(0).getString("middleName"));
            request.setAttribute("dob", bDocuments.get(0).getString("DOB"));
            request.setAttribute("phoneNumber", bDocuments.get(0).getLong("phoneNumber"));
            request.setAttribute("email", bDocuments.get(0).getString("email"));
            request.setAttribute("xraydye", bDocuments.get(0).getBoolean("xraydyeAllergy"));
            request.setAttribute("mridye", bDocuments.get(0).getBoolean("mriAllergy"));
            request.setAttribute("latex", bDocuments.get(0).getBoolean("latexAllergy"));
            request.setAttribute("asthma", bDocuments.get(0).getBoolean("ashtmaAllergy"));
            request.setAttribute("notes", bDocuments.get(0).getString("notes"));

            ArrayList<Document> orderDocuments = getOrders(bDocuments.get(0).getString("firstName"), bDocuments.get(0).getString("lastName"), bDocuments.get(0).getString("DOB"));

            String order = "";
            for (int i = orderDocuments.size()-1; i >= 0; i--) {
                int orderNum = orderDocuments.get(i).getInteger("orderNumber");
                String status = orderDocuments.get(i).getString("status");
                order += "<tr><td>" + orderNum + "</td><td>" + status + " </td><td><form method=\"POST\" action=\"\"><button type=\"submit\" name=\"btn\" id=\"btn\" value=\"" + orderNum + "_" + status + "\"> View</button></form></td></tr>";
                //order += "<tr><td>" + orderNum + "</td><td>" + status + " </td><td><button type=\"button\" onclick=\"/OrderRefPage\" name=\"btn\" id=\"btn\" value=\"" + orderNum + "_" + status + "\"> View</button></td></tr>";
            }


            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher("/patient/patientPage.jsp").forward(request, response);
        }
        else {
            System.out.println("Patient not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
