package com.handmadecode.reimbursementapp.model;

import java.util.Objects;
import java.util.Set;

public class Ticket {
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


    public Ticket() {
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

    @Override
    public String toString() {
        return "Ticket{" +
                "fullDaysNumber=" + fullDaysNumber +
                ", tripDateFrom='" + tripDateFrom + '\'' +
                ", tripDateTo='" + tripDateTo + '\'' +
                ", receipts=" + receipts +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(fullDaysNumber, ticket.fullDaysNumber) && Objects.equals(tripDateFrom, ticket.tripDateFrom) && Objects.equals(tripDateTo, ticket.tripDateTo) && Objects.equals(receipts, ticket.receipts) && Objects.equals(distance, ticket.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullDaysNumber, tripDateFrom, tripDateTo, receipts, distance);
    }
}
