package com.balu.vim.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.balu.vim.utils.DataSourceUtil;
/*
 * This Class used for Initial DB Scripts
 */
@WebListener
public class VimAppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Logger lgr = Logger.getLogger(VimAppInitializer.class.getName());
        lgr.log(Level.INFO, "Executing contextInitialized(ServletContextEvent sce)...");

        String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;" 
                + "INIT=RUNSCRIPT FROM 'classpath:/sql/VehicleTable.sql'";
        DataSourceUtil.getDataSource().setUrl(url);
        try (Connection con =  DataSourceUtil.getDataSource().getConnection()) {
        	lgr.log(Level.INFO, "Running Initial Create Table SQL Scripts..");
        } catch (SQLException ex) {
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}