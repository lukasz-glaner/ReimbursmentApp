package com.handmadecode.reimbursementapp.service;

import com.handmadecode.reimbursmentapp.dto.AdminSettingsUpdateDto;
import com.handmadecode.reimbursmentapp.dto.CalcSettingsDto;
import com.handmadecode.reimbursmentapp.model.CalcSettings;
import com.handmadecode.reimbursmentapp.service.CalcSettingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalcSettingsServiceTest {

    private CalcSettingsService calcSettingsService;

    @BeforeEach
    void setUp() {
        calcSettingsService = new CalcSettingsService();
    }

    @Test
    void init() {
        calcSettingsService.init();
        assertEquals(CalcSettingsService.DEFAULT_DAILY_ALLOWANCE, CalcSettingsService.calcSettings.getDailyAllowance());
        assertEquals(CalcSettingsService.DEFAULT_MILEAGE_COST, CalcSettingsService.calcSettings.getMileageCost());
        assertTrue(CalcSettingsService.calcSettings.getAvailableReceiptTypes().contains("Taxi"));
        assertEquals(20.0f, CalcSettingsService.calcSettings.getLimits().get("Taxi"));
    }

    @Test
    void calcSettingsMapper() {
        calcSettingsService.init();
        CalcSettingsDto calcSettingsDto = calcSettingsService.calcSettingsMapper(CalcSettingsService.calcSettings);

        assertEquals(CalcSettingsService.DEFAULT_DAILY_ALLOWANCE, calcSettingsDto.getDailyAllowance());
        assertEquals(CalcSettingsService.DEFAULT_MILEAGE_COST, calcSettingsDto.getMileageCost());
        assertTrue(calcSettingsDto.getAvailableReceiptTypes().contains("Taxi"));
        assertEquals(20.0f, calcSettingsDto.getLimits().get("Taxi"));
    }

    @Test
    void updateAdminCalcSettings() {
        calcSettingsService.init();

        AdminSettingsUpdateDto adminSettingsUpdateDto = new AdminSettingsUpdateDto();
        adminSettingsUpdateDto.setDailyAllowance(20.0f);
        adminSettingsUpdateDto.setMileageCost(0.4f);
        adminSettingsUpdateDto.setAvailableReceiptTypes(Set.of("Bus"));
        Map<String, Float> newLimits = new HashMap<>();
        newLimits.put("Bus", 30.0f);
        adminSettingsUpdateDto.setNewLimits(newLimits);

        CalcSettings updatedCalcSettings = calcSettingsService.updateAdminCalcSettings(adminSettingsUpdateDto);

        assertEquals(20.0f, updatedCalcSettings.getDailyAllowance());
        assertEquals(0.4f, updatedCalcSettings.getMileageCost());
        assertTrue(updatedCalcSettings.getAvailableReceiptTypes().contains("Bus"));
        assertEquals(30.0f, updatedCalcSettings.getLimits().get("Bus"));
    }
}
