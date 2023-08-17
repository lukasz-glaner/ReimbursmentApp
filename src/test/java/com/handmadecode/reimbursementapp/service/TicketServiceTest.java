package com.handmadecode.reimbursementapp.service;

import com.handmadecode.reimbursmentapp.dto.CalculatedTicketDto;
import com.handmadecode.reimbursmentapp.dto.TicketDto;
import com.handmadecode.reimbursmentapp.model.CalcSettings;
import com.handmadecode.reimbursmentapp.model.Receipt;
import com.handmadecode.reimbursmentapp.service.CalcSettingsService;
import com.handmadecode.reimbursmentapp.service.TicketService;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketServiceTest {
    @Test
    void createAndCalculateTicket() {

        CalcSettingsService.calcSettings = new CalcSettings();
        CalcSettingsService.calcSettings.setDailyAllowance(50f);
        CalcSettingsService.calcSettings.setMileageCost(1f);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setFullDaysNumber(3);
        ticketDto.setDistance(100);

        Set<Receipt> receipts = new HashSet<>();
        receipts.add(new Receipt("Taxi", "Description of taxi receipt", 100f));
        receipts.add(new Receipt("Hotel", "Description of hotel receipt", 50f));
        ticketDto.setReceipts(receipts);

        TicketService ticketService = new TicketService();
        CalculatedTicketDto calculatedTicketDto = ticketService.createAndCalculateTicket(ticketDto);

        assertEquals(400f, calculatedTicketDto.getSumOfCosts(), "Sum of costs should be equals 400");
        assertEquals(100f, calculatedTicketDto.getMileageCosts(), "Mileage costs should be equals 100");
    }
}
