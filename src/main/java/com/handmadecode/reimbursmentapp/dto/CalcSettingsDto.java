package com.handmadecode.reimbursmentapp.dto;

import java.util.Map;
import java.util.Set;

public class CalcSettingsDto {
    private float dailyAllowance;
    private float mileageCost;
    private Set<String> availableReceiptTypes;
    private Map<String,Float> limits;

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
}
