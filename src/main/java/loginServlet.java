import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import com.example.XamineRIS_RE_JAVA.*;
import org.bson.BsonDocument;

// WebServlet class that will handle any get or post request sent to the /login path
@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet implements UserLogin{

    public void init() {}

    // doGet method that handles the GET request sent from the webpage
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Grabs the context for the webpage and displays the login.jsp page and forwards the request and response to that page
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (username != null && password != null) {
            BsonDocument bsonDocument = loginAttempt(username, password);
            if (bsonDocument != null) {
                if (bsonDocument.getInt32("groupId").getValue() == 1) {
                    session.setAttribute("user", username);
                    response.sendRedirect("/patientPortal");
                }
                else if (bsonDocument.getInt32("groupId").getValue() == 2) {
                    session.setAttribute("user", username);
                    response.sendRedirect("/receptionist");
                }
                else if (bsonDocument.getInt32("groupId").getValue() == 5) {
                    session.setAttribute("user", username);
                    response.sendRedirect("/admin");
                }
            }
            else {
                String error = "Username or Password incorrect, Please enter a valid username and password.";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    public void destroy(){

    }
}
