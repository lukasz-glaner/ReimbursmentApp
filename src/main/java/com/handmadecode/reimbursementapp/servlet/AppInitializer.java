package com.handmadecode.reimbursementapp.servlet;

import com.handmadecode.reimbursementapp.service.CalcSettingsService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        CalcSettingsService calcSettingsService = new CalcSettingsService();

        calcSettingsService.init();

        sce.getServletContext().setAttribute("calcSettingsService", calcSettingsService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
