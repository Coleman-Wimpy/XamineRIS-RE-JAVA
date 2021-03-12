import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

// WebServlet class that will handle any get or post request sent to the /login path
@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {

    public void init() {}

    // doGet method that handles the GET request sent from the webpage
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Grabs the context for the webpage and displays the login.jsp page and forwards the request and response to that page
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }

    public void destroy(){

    }
}
