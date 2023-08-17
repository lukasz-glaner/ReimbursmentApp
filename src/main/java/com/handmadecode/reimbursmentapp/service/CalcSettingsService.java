package com.handmadecode.reimbursmentapp.service;

import com.handmadecode.reimbursmentapp.dto.AdminSettingsUpdateDto;
import com.handmadecode.reimbursmentapp.dto.CalcSettingsDto;
import com.handmadecode.reimbursmentapp.model.CalcSettings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CalcSettingsService {

    public static final float DEFAULT_DAILY_ALLOWANCE = 15.0f;
    public static final float DEFAULT_MILEAGE_COST = 0.3f;
    public static CalcSettings calcSettings;

    public void init() {
        calcSettings = new CalcSettings();
        calcSettings.setDailyAllowance(DEFAULT_DAILY_ALLOWANCE);
        calcSettings.setMileageCost(DEFAULT_MILEAGE_COST);
        calcSettings.setAvailableReceiptTypes(new HashSet<>(Set.of("Taxi", "Plane", "Train", "Hotel")));
        Map<String, Float> limits = new HashMap<>();
        limits.put("Taxi", 20.0f);
        limits.put("Plane", 200.0f);
        limits.put("Train", 50.0f);
        limits.put("Hotel", 300.0f);
        limits.put("Total", 1000.0f);
        limits.put("Distance", 500.0f);
        calcSettings.setLimits(limits);
    }

    public CalcSettingsDto calcSettingsMapper(CalcSettings calcSettings) {
        CalcSettingsDto calcSettingsDto = new CalcSettingsDto();
        calcSettingsDto.setDailyAllowance(calcSettings.getDailyAllowance());
        calcSettingsDto.setMileageCost(calcSettings.getMileageCost());
        calcSettingsDto.setAvailableReceiptTypes(calcSettings.getAvailableReceiptTypes());
        calcSettingsDto.setLimits(calcSettings.getLimits());
        return calcSettingsDto;
    }

    public CalcSettings updateAdminCalcSettings(AdminSettingsUpdateDto adminSettingsUpdateDto) {
        calcSettings.setDailyAllowance(adminSettingsUpdateDto.getDailyAllowance());
        calcSettings.setMileageCost(adminSettingsUpdateDto.getMileageCost());
        calcSettings.getAvailableReceiptTypes().addAll(adminSettingsUpdateDto.getAvailableReceiptTypes());
        if (adminSettingsUpdateDto.getNewReceiptTypes() != null) {
            calcSettings.getAvailableReceiptTypes().addAll(adminSettingsUpdateDto.getNewReceiptTypes());
        }
        calcSettings.getLimits().putAll(adminSettingsUpdateDto.getLimits());
        calcSettings.getLimits().putAll(adminSettingsUpdateDto.getNewLimits());
        return calcSettings;
    }
}
