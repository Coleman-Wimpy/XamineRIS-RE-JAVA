import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.XamineRIS_RE_JAVA.*;
import org.bson.BsonDocument;

// WebServlet that will handle any GET or POST request sent to the /admin path
@WebServlet(name = "adminServlet", value = "/admin")
public class adminServlet extends HttpServlet implements PatientsInterface{

    private HttpServletRequest request;

    // doGet method that handles any GET requests sent to /admin
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forwards the request and response information to the /administrator.jsp page to display it to the user

    }

    // doPost method that handles any POST requests sent to /admin
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (firstName != null && lastName != null) {
            BsonDocument bsonDocument = getPatients(firstName, lastName);
            if (bsonDocument != null) {
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                getServletContext().getRequestDispatcher("/patientSearch.jsp").forward(request, response);
            }
        }
    }
}
