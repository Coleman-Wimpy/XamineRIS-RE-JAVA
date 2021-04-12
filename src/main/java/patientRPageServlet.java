import com.example.XamineRIS_RE_JAVA.OrderInterface;
import com.example.XamineRIS_RE_JAVA.Patient;
import com.example.XamineRIS_RE_JAVA.PatientsInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "patientRPageServlet", value = "/patientRPage")
public class patientRPageServlet extends HttpServlet implements PatientsInterface, OrderInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("btn");
        int split = name.indexOf('_');

        String fName = name.substring(0, split);
        String lName = name.substring(split+1);
        System.out.println(fName + " " + lName);

        ArrayList<Document> bDocuments = getPatient(fName, lName);

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

            ArrayList<Document> orderDocument = getOrders(fName, lName, bDocuments.get(0).getString("DOB"));


            getServletContext().getRequestDispatcher("/patientRPage.jsp").forward(request, response);
        }
        else {
            System.out.println("Patient not found");
        }
    }
}
