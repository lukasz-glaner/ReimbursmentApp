package com.handmadecode.reimbursmentapp.dto;

import com.handmadecode.reimbursmentapp.model.Receipt;

import java.util.Set;

public class CalculatedTicketDto {
    private Integer fullDaysNumber;
    private String tripDateFrom;
    private String tripDateTo;
    private Set<Receipt> receipts;
    private Float sumOfCosts;
    private Integer distance;

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

    public Float getSumOfCosts() {
        return sumOfCosts;
    }

    public void setSumOfCosts(Float sumOfCosts) {
        this.sumOfCosts = sumOfCosts;
    }
}
