package com.handmadecode.reimbursementapp.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdminSettingsUpdateDto {
    private float dailyAllowance;
    private float mileageCost;
    private Set<String> availableReceiptTypes;
    private Map<String,Float> limits = new HashMap<>();
    private Set<String> newReceiptTypes;
    private Map<String,Float> newLimits = new HashMap<>();

    public float getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(float dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }

    public float getMileageCost() {
        return mileageCost;
    }

    public void setMileageCost(float mileageCost) {
        this.mileageCost = mileageCost;
    }

    public Set<String> getAvailableReceiptTypes() {
        return availableReceiptTypes;
    }

    public void setAvailableReceiptTypes(Set<String> availableReceiptTypes) {
        this.availableReceiptTypes = availableReceiptTypes;
    }

    public Map<String, Float> getLimits() {
        return limits;
    }

    public void setLimits(Map<String, Float> limits) {
        this.limits = limits;
    }

    public Set<String> getNewReceiptTypes() {
        return newReceiptTypes;
    }

    public void setNewReceiptTypes(Set<String> newReceiptTypes) {
        this.newReceiptTypes = newReceiptTypes;
    }

    public Map<String, Float> getNewLimits() {
        return newLimits;
    }

    public void setNewLimits(Map<String, Float> newLimits) {
        this.newLimits = newLimits;
    }
}
