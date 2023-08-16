package com.handmadecode.reimbursmentapp.servlet;

import com.handmadecode.reimbursmentapp.User;
import com.handmadecode.reimbursmentapp.service.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserPage", value = "/userPage")
public class UserPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("availableReceiptTypes", TicketService.availableReceiptTypes);
        request.getRequestDispatcher("/userPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
