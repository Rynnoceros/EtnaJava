/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core;

/**
 * Log manager class
 * @author rynnoceros
 */
public class LogManager {
	/**
	 * Singleton implementation with Holder
	 * @author soubri_j/martin_m
	 */
	private static class LogManagerHolder {
		private static final LogManager instance = new LogManager();
	}
	
    /**
     * Returns a unique instance of LogManager. 
     * 
     * @return The unique instance of LogManager. 
     */
    public static LogManager getInstance() {
        return LogManagerHolder.instance;
    }
 
    /**
     * Service initialization. 
     */
    public void init(){
    	System.out.println("Log : Initialisation du service");
    }
 
    /**
     * Logs a message. 
     * @param Message to log. 
     */
    public void log(String message){
        System.out.println("Log : " + message);
    }
}
