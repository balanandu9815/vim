package com.balu.vim.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//Util Class for DataSource Instance
public class DataSourceUtil {
    
    private static DataSourceUtil instance=new DataSourceUtil();
    private SimpleDriverDataSource simpleDriverDataSource;
    private JdbcTemplate jdbcTemplate;
    private static String DB_URL="jdbc:h2:mem:test";
    public static DataSourceUtil getInstance(){
            return instance;
    }
    
    private DataSourceUtil(){
    	simpleDriverDataSource = new SimpleDriverDataSource();
    	simpleDriverDataSource.setDriver(new org.h2.Driver());
    	simpleDriverDataSource.setUrl(DB_URL);
    	jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
    }
    
    public static JdbcTemplate getSession(){
        return getInstance().jdbcTemplate;
    }
    
    public static SimpleDriverDataSource getDataSource(){
        return getInstance().simpleDriverDataSource;
    }
}
 