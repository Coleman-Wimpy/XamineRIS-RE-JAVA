import com.example.XamineRIS_RE_JAVA.PatientsInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "receptionistServlet", value = "/receptionist")
public class receptionistServlet extends HttpServlet implements PatientsInterface {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/patientSearch.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("POST Recieved");
        String dob = request.getParameter("dob");
        System.out.println(dob);

        if (dob != null) {
            ArrayList<Document> bDocuments = getPatients(dob);
            System.out.println("Grabbing patients");

            for (int i = bDocuments.size()-1; i >= 0; i--) {
                System.out.println(bDocuments.get(i).getString("firstName"));

                String fName = bDocuments.get(i).getString("firstName");
                String lName = bDocuments.get(i).getString("lastName");
                String Dob = bDocuments.get(i).getString("DOB");
                String result = "<li>" + fName + " " + lName + " D.O.B: " + Dob + "</li>";
                System.out.println(result);
                request.setAttribute("patient", result);
                request.setAttribute("current_dob", Dob);
                getServletContext().getRequestDispatcher("/patientSearch.jsp").forward(request, response);
            }
        }
        else {
            System.out.println("DOB not recieved.");
        }

    }
}
