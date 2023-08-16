package com.handmadecode.reimbursmentapp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminPage", value = "/adminPage")
public class AdminPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendResponse(response);
    }

    private void sendResponse(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h2>admin page</h2>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
