/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.file;

/**
 *
 * @author soubri_j/martin_m
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropert {
	public static void main(final String[] args) {

		final Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("domaine/properties/constant.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("semaine"));
			

		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}