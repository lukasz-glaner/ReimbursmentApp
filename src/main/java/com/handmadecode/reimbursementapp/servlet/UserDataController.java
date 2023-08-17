package com.handmadecode.reimbursementapp.servlet;

import com.handmadecode.reimbursementapp.dto.CalculatedTicketDto;
import com.handmadecode.reimbursementapp.dto.TicketDto;
import com.handmadecode.reimbursementapp.model.Receipt;
import com.handmadecode.reimbursementapp.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "expensesCalculation", value = "/expensesCalculation")
public class UserDataController extends HttpServlet {
    private TicketService ticketService;

    @Override
    public void init() {
        ticketService = new TicketService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TicketDto ticketDto = createTicketDto(request);
        CalculatedTicketDto calculatedTicketDto = ticketService.createAndCalculateTicket(ticketDto);
        request.setAttribute("calculatedExpenses", calculatedTicketDto);
        request.getRequestDispatcher("/calculatedExpenses.jsp").forward(request, response);
    }

    private TicketDto createTicketDto(HttpServletRequest request) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setFullDaysNumber(Integer.valueOf(request.getParameter("fullDaysNumber")));
        ticketDto.setTripDateFrom(request.getParameter("tripDateFrom"));
        ticketDto.setTripDateTo(request.getParameter("tripDateTo"));
        Set<Receipt> receipts = new HashSet<>();
        String[] types = request.getParameterValues("type");
        String[] descriptions = request.getParameterValues("description");
        String[] costs = request.getParameterValues("cost");

        for (int i = 0; i < types.length; i++) {
            Receipt receipt = new Receipt();
            receipt.setType(types[i]);
            receipt.setDescription(descriptions[i]);
            receipt.setCost(Float.parseFloat(costs[i]));
            receipts.add(receipt);
        }
        ticketDto.setReceipts(receipts);
        ticketDto.setDistance(Integer.valueOf(request.getParameter("distance")));
        return ticketDto;
    }
}
