package com.example.XamineRIS_RE_JAVA.patient;

import com.example.XamineRIS_RE_JAVA.patient.PatientsInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;

@WebServlet(name = "com.example.XamineRIS_RE_JAVA.patient.newPatientServlet", value = "/patient/new")
public class newPatientServlet extends HttpServlet implements PatientsInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String middleName = "";

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        middleName += request.getParameter("middleName");
        String email = request.getParameter("email");
        long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String birthDate = request.getParameter("birthDate");
        boolean asthmaAllergy = Boolean.parseBoolean(request.getParameter("asthmaAllergy"));
        boolean xraydyeAllergy = Boolean.parseBoolean(request.getParameter("xraydyeAllergy"));
        boolean mriAllergy = Boolean.parseBoolean(request.getParameter("mriAllergy"));
        boolean latexAllergy = Boolean.parseBoolean(request.getParameter("latexAllergy"));
        String notes = request.getParameter("notes");

        Document patient = new Document("DOB", birthDate)
                .append("firstName" , firstName).append("middleName", middleName).append("lastName", lastName)
                .append("email", email)
                .append("phoneNumber", phoneNumber)
                .append("ashtmaAllergy", asthmaAllergy)
                .append("xraydyeAllergy", xraydyeAllergy)
                .append("mriAllergy", mriAllergy)
                .append("latexAllergy", latexAllergy)
                .append("notes", notes);

        boolean task = createPatient(patient);

        if (task == true) {
            request.setAttribute("message", "Patient Added");
        }else
        {
            request.setAttribute("message", "Error adding new patient");
        }
        getServletContext().getRequestDispatcher("/patientSearch.jsp").forward(request, response);
    }
}
