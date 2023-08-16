package com.handmadecode.reimbursmentapp.model;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CalcSettings {
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

    @Override
    public String toString() {
        return "CalcSettings{" +
                "dailyAllowance=" + dailyAllowance +
                ", mileageCost=" + mileageCost +
                ", availableReceiptTypes=" + availableReceiptTypes +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcSettings that = (CalcSettings) o;
        return Float.compare(that.dailyAllowance, dailyAllowance) == 0 && Float.compare(that.mileageCost, mileageCost) == 0 && Objects.equals(availableReceiptTypes, that.availableReceiptTypes) && Objects.equals(limits, that.limits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailyAllowance, mileageCost, availableReceiptTypes, limits);
    }
}
