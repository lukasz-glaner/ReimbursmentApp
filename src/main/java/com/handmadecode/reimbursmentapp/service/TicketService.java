package com.handmadecode.reimbursmentapp.service;

import com.handmadecode.reimbursmentapp.dto.CalculatedTicketDto;
import com.handmadecode.reimbursmentapp.dto.TicketDto;
import com.handmadecode.reimbursmentapp.model.Receipt;
import com.handmadecode.reimbursmentapp.model.Ticket;

import java.util.Set;

public class TicketService {
    private static final float DAILY_ALLOWANCE = 15;
    public static Set<String> availableReceiptTypes = Set.of("Taxi", "Plane", "Train", "Hotel");

    public CalculatedTicketDto createAndCalculateTicket(TicketDto ticketDto) {
        float sumOfCosts;

        Ticket ticket = ticketDtoMapper(ticketDto);
        Float calculatedDailyAllowance = calculateDailyAllowance(ticket);
        Float calculatedReceiptsCosts = calculateReceiptsCosts(ticket.getReceipts());
        sumOfCosts = calculatedDailyAllowance + calculatedReceiptsCosts;

        return ticketMapper(ticket, sumOfCosts);
    }

    private Ticket ticketDtoMapper(TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setFullDaysNumber(ticketDto.getFullDaysNumber());
        ticket.setTripDateFrom(ticketDto.getTripDateFrom());
        ticket.setTripDateTo(ticketDto.getTripDateTo());
        ticket.setReceipts(ticketDto.getReceipts());
        return ticket;
    }

    private CalculatedTicketDto ticketMapper(Ticket ticket, Float sumOfCosts){
        CalculatedTicketDto calculatedTicketDto = new CalculatedTicketDto();
        calculatedTicketDto.setSumOfCosts(sumOfCosts);
        calculatedTicketDto.setTripDateFrom(ticket.getTripDateFrom());
        calculatedTicketDto.setTripDateTo(ticket.getTripDateTo());
        calculatedTicketDto.setFullDaysNumber(ticket.getFullDaysNumber());
        calculatedTicketDto.setReceipts(ticket.getReceipts());

        return calculatedTicketDto;
    }
    private float calculateDailyAllowance(Ticket ticket){
        return ticket.getFullDaysNumber() * DAILY_ALLOWANCE;
    }

    private float calculateReceiptsCosts(Set<Receipt> receipts){
        return receipts.stream().map(Receipt::getCost).reduce(0f, Float::sum);
    }
}
