package com.handmadecode.reimbursmentapp.servlet;

import com.handmadecode.reimbursmentapp.dto.AdminSettingsUpdateDto;
import com.handmadecode.reimbursmentapp.model.CalcSettings;
import com.handmadecode.reimbursmentapp.service.CalcSettingsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.handmadecode.reimbursmentapp.service.CalcSettingsService.calcSettings;

@WebServlet(name = "AdminPage", value = "/adminPage")
public class AdminPageController extends HttpServlet {
    CalcSettingsService calcSettingsService;

    @Override
    public void init() {
        calcSettingsService = new CalcSettingsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("calcSettingsDto", calcSettingsService.calcSettingsMapper(calcSettings));
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminSettingsUpdateDto adminSettingsUpdateDto = createAdminSettingsUpdateDto(request);
        CalcSettings updatedCalcSettings = calcSettingsService.updateAdminCalcSettings(adminSettingsUpdateDto);
        request.setAttribute("calcSettingsDto", calcSettingsService.calcSettingsMapper(CalcSettingsService.calcSettings));
        request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    }
    private AdminSettingsUpdateDto createAdminSettingsUpdateDto(HttpServletRequest request) {
        AdminSettingsUpdateDto adminSettingsUpdateDto = new AdminSettingsUpdateDto();
        setBasicSettings(adminSettingsUpdateDto, request);
        setLimits(adminSettingsUpdateDto, request);
        setNewReceiptTypesAndLimits(adminSettingsUpdateDto, request);
        return adminSettingsUpdateDto;
    }
    private void setBasicSettings(AdminSettingsUpdateDto adminSettingsUpdateDto, HttpServletRequest request) {
        adminSettingsUpdateDto.setDailyAllowance(Float.parseFloat(request.getParameter("dailyAllowance")));
        adminSettingsUpdateDto.setMileageCost(Float.parseFloat(request.getParameter("mileageCost")));
        adminSettingsUpdateDto.setAvailableReceiptTypes(Collections.singleton(request.getParameter("availableReceiptTypes")));
    }

    private void setLimits(AdminSettingsUpdateDto adminSettingsUpdateDto, HttpServletRequest request) {
        Map<String, Float> limits = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("limits_")) {
                String key = paramName.substring(7);
                String valueString = request.getParameter(paramName);
                Float value = Float.parseFloat(valueString);
                limits.put(key, value);
            }
        }
        adminSettingsUpdateDto.setLimits(limits);
    }

    private void setNewReceiptTypesAndLimits(AdminSettingsUpdateDto adminSettingsUpdateDto, HttpServletRequest request) {
        String[] newReceiptTypes = request.getParameterValues("newReceiptType");
        String[] newLimits = request.getParameterValues("limit");

        if (newReceiptTypes != null && newLimits != null) {
            adminSettingsUpdateDto.setNewReceiptTypes(Set.of(newReceiptTypes));
            for (int i = 0; i < newReceiptTypes.length; i++) {
                String newReceiptType = newReceiptTypes[i];
                Float limit = Float.parseFloat(newLimits[i]);
                adminSettingsUpdateDto.getNewLimits().put(newReceiptType, limit);
            }
        }
    }

//    private AdminSettingsUpdateDto createAdminSettingsUpdateDto(HttpServletRequest request) {
//        AdminSettingsUpdateDto adminSettingsUpdateDto = new AdminSettingsUpdateDto();
//        adminSettingsUpdateDto.setDailyAllowance(Float.parseFloat(request.getParameter("dailyAllowance")));
//        adminSettingsUpdateDto.setMileageCost(Float.parseFloat(request.getParameter("mileageCost")));
//        adminSettingsUpdateDto.setAvailableReceiptTypes(Collections.singleton(request.getParameter("availableReceiptTypes")));
//        Map<String, Float> limits = new HashMap<>();
//
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            if (paramName.startsWith("limits_")) {
//                String key = paramName.substring(7);
//                String valueString = request.getParameter(paramName);
//                Float value = Float.parseFloat(valueString);
//                limits.put(key, value);
//            }
//        }
//        adminSettingsUpdateDto.setLimits(limits);
//
//        String[] newReceiptTypes = request.getParameterValues("newReceiptType");
//        String[] newLimits = request.getParameterValues("limit");
//
//        if (newReceiptTypes != null && newLimits != null) {
//            adminSettingsUpdateDto.setNewReceiptTypes(Set.of(newReceiptTypes));
//            for (int i = 0; i < newReceiptTypes.length; i++) {
//                String newReceiptType = newReceiptTypes[i];
//                Float limit = Float.parseFloat(newLimits[i]);
//                adminSettingsUpdateDto.getNewLimits().put(newReceiptType, limit);
//            }
//        }
//        return adminSettingsUpdateDto;
//    }
}
