package com.handmadecode.reimbursementapp.dto;

import com.handmadecode.reimbursementapp.model.Receipt;

import java.util.Set;

public class TicketDto {

    private Integer fullDaysNumber;
    private String tripDateFrom;
    private String tripDateTo;
    private Set<Receipt> receipts;
    private Integer distance;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getTripDateFrom() {
        return tripDateFrom;
    }

    public void setTripDateFrom(String tripDateFrom) {
        this.tripDateFrom = tripDateFrom;
    }

    public String getTripDateTo() {
        return tripDateTo;
    }

    public void setTripDateTo(String tripDateTo) {
        this.tripDateTo = tripDateTo;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Integer getFullDaysNumber() {
        return fullDaysNumber;
    }

    public void setFullDaysNumber(Integer fullDaysNumber) {
        this.fullDaysNumber = fullDaysNumber;
    }
}
