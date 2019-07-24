/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao;

import com.cours.ebenus.utils.Constants;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class use to centralize all connection to the database
 * @author soubri_j/martin_m
 */
public class DataSourceSingleton {
    private static final Log log = LogFactory.getLog(DataSourceSingleton.class);
    public final static String className = DataSourceSingleton.class.getName();
    // Objet DataSource
    private DataSource dataSource = null;
    
    private DataSourceSingleton() {
    	BasicDataSource ds = new BasicDataSource();
    	ds.setMaxActive(Constants.DATABASE_MAX_CONNECTIONS);
    	ds.setDriverClassName(Constants.JDBC_DRIVER);
    	ds.setUrl(Constants.DATABASE_URL);
    	ds.setUsername(Constants.DATABASE_USER);
    	ds.setPassword(Constants.DATABASE_PASSWORD);
    	this.dataSource = ds;
    }
        
    private static class DataSourceSingletonHolder {
    	private static final DataSourceSingleton instance = new DataSourceSingleton();
    }
    
    public static DataSource getInstance() {
    	return DataSourceSingletonHolder.instance.dataSource;
    }
}
