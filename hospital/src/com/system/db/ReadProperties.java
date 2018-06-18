package com.system.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	
	public Properties readProperty() {
		
		Properties properties = new Properties();
		try {
			InputStream is = getClass().getResourceAsStream("/database.properties");
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public String getProperty(String propertyKey) {
		ReadProperties readProp = new ReadProperties();
		Properties properties = readProp.readProperty();
		String propertyValue = properties.getProperty(propertyKey);
		return propertyValue;
	}
	
	public static void main(String[] args) {
		ReadProperties read = new ReadProperties();
		System.out.println(read.getProperty("DBDRIVER"));
	}
}
