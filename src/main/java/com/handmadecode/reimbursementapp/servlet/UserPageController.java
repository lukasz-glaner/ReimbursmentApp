package com.handmadecode.reimbursementapp.servlet;

import com.handmadecode.reimbursementapp.service.CalcSettingsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserPage", value = "/userPage")
public class UserPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("availableReceiptTypes", CalcSettingsService.calcSettings.getAvailableReceiptTypes());
        request.getRequestDispatcher("/userPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
