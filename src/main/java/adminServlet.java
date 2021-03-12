import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// WebServlet that will handle any GET or POST request sent to the /admin path
@WebServlet(name = "adminServlet", value = "/admin")
public class adminServlet extends HttpServlet {

    private HttpServletRequest request;

    // doGet method that handles any GET requests sent to /admin
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // forwards the request and response information to the /administrator.jsp page to display it to the user
        getServletContext().getRequestDispatcher("/administrator.jsp").forward(request, response);
    }

    // doPost method that handles any POST requests sent to /admin
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // stores the values that are in the username and password fields of the webpage into local strings
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        doGet(request,response);
    }
}
