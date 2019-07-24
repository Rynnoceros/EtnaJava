package com.cours.utils;

public final class StringUtil {

    /**
     * Method used to get fields from a line
     * @param line Line to read
     * @param separator Separator
     * @return A list of fields if ok, null otherwise.
     */
    public static String[] getFields(String line, String separator) {
    	String headers[] = null;
    	
    	if (line != null && line.length() > 0) {
    		headers = line.split(separator);
    	}
    	
    	return headers;
    }
}
