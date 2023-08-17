package com.handmadecode.reimbursmentapp.model;

import java.util.Objects;

public class Receipt {
    String type;
    String description;
    Float cost;

    public Receipt() {
    }

    public Receipt(String type, String description, Float cost) {
        this.type = type;
        this.description = description;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(type, receipt.type) && Objects.equals(description, receipt.description) && Objects.equals(cost, receipt.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description, cost);
    }
}
