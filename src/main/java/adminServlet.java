import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import com.example.XamineRIS_RE_JAVA.*;

// WebServlet that will handle any GET or POST request sent to the /admin path
@WebServlet(name = "adminServlet", value = "/admin")
public class adminServlet extends HttpServlet {

    private HttpServletRequest request;

    // doGet method that handles any GET requests sent to /admin
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forwards the request and response information to the /administrator.jsp page to display it to the user

    }

    // doPost method that handles any POST requests sent to /admin
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/administrator.jsp").forward(request, response);
    }
}
