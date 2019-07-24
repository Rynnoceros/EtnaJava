/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ConnectionHelper {

    private static final Log log = LogFactory.getLog(ConnectionHelper.class);
    public final static String className = ConnectionHelper.class.getName();

    public static void closeSqlResources(Connection connection, PreparedStatement preparedStatement, ResultSet result) {
    	if (result != null) {
    		try {
				result.close();
			} catch (SQLException e) {
				log.error("Error closing resultset : " + e.getLocalizedMessage());
			}
    	}
    	if (preparedStatement != null) {
    		try {
				preparedStatement.close();
			} catch (SQLException e) {
				log.error("Error closing preparedstatement : " + e.getLocalizedMessage());
			}
    	}
    	if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				log.error("Error closing connection : " + e.getLocalizedMessage());
			}
    	}
    }
}
