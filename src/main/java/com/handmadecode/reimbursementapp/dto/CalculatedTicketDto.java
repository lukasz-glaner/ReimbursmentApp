package com.handmadecode.reimbursementapp.dto;

import com.handmadecode.reimbursementapp.model.Receipt;

import java.util.Set;

public class CalculatedTicketDto {
    private Integer fullDaysNumber;
    private String tripDateFrom;
    private String tripDateTo;
    private Set<Receipt> receipts;
    private Float sumOfCosts;
    private Integer distance;
    private Float mileageCosts;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Float getMileageCosts() {
        return mileageCosts;
    }

    public void setMileageCosts(Float mileageCosts) {
        this.mileageCosts = mileageCosts;
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

    public Float getSumOfCosts() {
        return sumOfCosts;
    }

    public void setSumOfCosts(Float sumOfCosts) {
        this.sumOfCosts = sumOfCosts;
    }
}
