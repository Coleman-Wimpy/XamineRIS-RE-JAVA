package com.example.XamineRIS_RE_JAVA.technician;

import com.example.XamineRIS_RE_JAVA.order.OrderInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.Document;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ImageUploadHelperServlet", value = "/ImageUploadHelper")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class ImageUploadHelperServlet extends HttpServlet implements OrderInterface {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int orderNum = Integer.parseInt(session.getAttribute("orderNum").toString());

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String patientName = request.getParameter("patientName");
        System.out.println(patientName);
        for (Part part: request.getParts()) {
            part.write("C:\\Users\\cwimp\\IdeaProjects\\XamineRIS-RE-JAVA\\src\\main\\webapp\\patientImages\\" + patientName + "\\" + fileName);
            String filePath = "C:\\Users\\cwimp\\IdeaProjects\\XamineRIS-RE-JAVA\\src\\main\\webapp\\patientImages\\" + patientName + "\\" + fileName;
        }


        ArrayList<Document> orders = getOrder(orderNum);

        if(orders != null) {
            request.setAttribute("orderNum", orderNum);
            request.setAttribute("firstName", orders.get(0).getString("firstName"));
            request.setAttribute("lastName", orders.get(0).getString("lastName"));
            request.setAttribute("reason", orders.get(0).getString("reason"));
            request.setAttribute("imaging", orders.get(0).getString("imaging"));
            request.setAttribute("modality", orders.get(0).getString("modality"));
            request.setAttribute("orderNotes", orders.get(0).getString("orderNotes"));
        }

        File images = new File("C:\\Users\\cwimp\\IdeaProjects\\XamineRIS-RE-JAVA\\src\\main\\webapp\\patientImages\\" + patientName);
        String contents[] = images.list();
        String imageList = "";

        for(int i = 0; i < contents.length; i++)
        {
            imageList += "<form method=\"POST\" action=\"/imageTechView\">" + contents[i] + "<button type=\"submit\" name=\"btn\" value=\"/patientImages/" + patientName + "/" + contents[i] + "\">View</button></form><br>";        }

        request.setAttribute("images", imageList);
        getServletContext().getRequestDispatcher("/technician/orderTechView.jsp").forward(request, response);
    }
}
