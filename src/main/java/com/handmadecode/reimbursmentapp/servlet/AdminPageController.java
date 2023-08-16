package com.handmadecode.reimbursmentapp.servlet;

import com.handmadecode.reimbursmentapp.service.CalcSettingsService;
import com.handmadecode.reimbursmentapp.service.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.handmadecode.reimbursmentapp.service.CalcSettingsService.calcSettings;

@WebServlet(name = "AdminPage", value = "/adminPage")
public class AdminPageController extends HttpServlet {
    CalcSettingsService calcSettingsService;
    @Override
    public void init() {
        calcSettingsService = new CalcSettingsService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("calcSettingsDto", calcSettingsService.calcSettingsMapper(calcSettings));
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("calcSettingsDto", calcSettingsService.calcSettingsMapper(calcSettings));
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }
}
