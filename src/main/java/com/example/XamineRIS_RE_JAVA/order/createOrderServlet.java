package com.example.XamineRIS_RE_JAVA.order;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import com.example.XamineRIS_RE_JAVA.patient.PatientsInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "com.example.XamineRIS_RE_JAVA.order.createOrderServlet", value = "/createOrder")
public class createOrderServlet extends HttpServlet implements OrderInterface, PatientsInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String reason = request.getParameter("reason");
        String imaging = request.getParameter("imaging");
        String modality = request.getParameter("modality");
        String orderNotes = request.getParameter("orderNotes");

        int orderNum = getOrderNumber();

        Document order = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("DOB", dob)
                .append("reason", reason)
                .append("imaging", imaging)
                .append("modality", modality)
                .append("status", "Referral Placed")
                .append("orderNotes", orderNotes);

        boolean task = createOrder(order);

        request.setAttribute("orderNumber", orderNum);

        if (task == true) {
            request.setAttribute("message", "Order Created");
        }else
        {
            request.setAttribute("message", "Error creating order");
        }

        ArrayList<Document> bDocuments = getPatient(firstName, lastName);

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

            ArrayList<Document> orderDocuments = getOrders(firstName, lastName, bDocuments.get(0).getString("DOB"));

            String orders = "";
            for (int i = orderDocuments.size()-1; i >= 0; i--) {
                int orderNums = orderDocuments.get(i).getInteger("orderNumber");
                String status = orderDocuments.get(i).getString("status");
                orders += "<tr><td>" + orderNums + "</td><td>" + status + " </td><td><form method=\"POST\" action=\"/OrderRefPage\"><button type=\"submit\" name=\"btn\" id=\"btn\" value=\"" + orderNums + "_" + status + "\"> View</button></form></td></tr>";
                //order += "<tr><td>" + orderNum + "</td><td>" + status + " </td><td><button type=\"button\" onclick=\"/OrderRefPage\" name=\"btn\" id=\"btn\" value=\"" + orderNum + "_" + status + "\"> View</button></td></tr>";
            }


            request.setAttribute("order", orders);
            getServletContext().getRequestDispatcher("/referral/patientRefPage.jsp").forward(request, response);
        }
    }
}
