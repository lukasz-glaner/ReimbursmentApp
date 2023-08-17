package com.handmadecode.reimbursmentapp.service;

import com.handmadecode.reimbursmentapp.dto.CalculatedTicketDto;
import com.handmadecode.reimbursmentapp.dto.TicketDto;
import com.handmadecode.reimbursmentapp.model.Receipt;
import com.handmadecode.reimbursmentapp.model.Ticket;

import java.util.Set;

public class TicketService {
    public CalculatedTicketDto createAndCalculateTicket(TicketDto ticketDto) {
        float sumOfCosts;

        Ticket ticket = ticketDtoMapper(ticketDto);
        Float calculatedDailyAllowance = calculateDailyAllowance(ticket);
        Float calculatedReceiptsCosts = calculateReceiptsCosts(ticket.getReceipts());
        Float calculatedMileageCost = calculateMileageCosts(ticket.getDistance());
        sumOfCosts = calculatedDailyAllowance + calculatedReceiptsCosts + calculatedMileageCost;

        return ticketMapper(ticket, sumOfCosts, calculatedMileageCost);
    }

    private Float calculateMileageCosts(Integer distance) {
        return distance * CalcSettingsService.calcSettings.getMileageCost();
    }

    private Ticket ticketDtoMapper(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setFullDaysNumber(ticketDto.getFullDaysNumber());
        ticket.setTripDateFrom(ticketDto.getTripDateFrom());
        ticket.setTripDateTo(ticketDto.getTripDateTo());
        ticket.setReceipts(ticketDto.getReceipts());
        ticket.setDistance(ticketDto.getDistance());
        return ticket;
    }

    private CalculatedTicketDto ticketMapper(Ticket ticket, Float sumOfCosts, Float mileageCosts) {
        CalculatedTicketDto calculatedTicketDto = new CalculatedTicketDto();
        calculatedTicketDto.setSumOfCosts(sumOfCosts);
        calculatedTicketDto.setTripDateFrom(ticket.getTripDateFrom());
        calculatedTicketDto.setTripDateTo(ticket.getTripDateTo());
        calculatedTicketDto.setFullDaysNumber(ticket.getFullDaysNumber());
        calculatedTicketDto.setReceipts(ticket.getReceipts());
        calculatedTicketDto.setDistance(ticket.getDistance());
        calculatedTicketDto.setMileageCosts(mileageCosts);

        return calculatedTicketDto;
    }

    private float calculateDailyAllowance(Ticket ticket) {
        return ticket.getFullDaysNumber() * CalcSettingsService.calcSettings.getDailyAllowance();
    }

    private float calculateReceiptsCosts(Set<Receipt> receipts) {
        return receipts.stream().map(Receipt::getCost).reduce(0f, Float::sum);
    }
}
