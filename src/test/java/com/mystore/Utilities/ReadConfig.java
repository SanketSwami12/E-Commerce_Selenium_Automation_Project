package com.mystore.Utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadConfig 
{
	Properties properties;
	
	String path ="C:\\Users\\sanke\\eclipse-workspace\\E-commerce_MyShop\\Configuration\\config.properties";

	// Create constructor
	
	public ReadConfig() 
	{
		properties = new Properties();
		try {
		FileInputStream fis = new FileInputStream(path);
		
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 // now whatever keys we are created in config.properties file we can call them here by creating different methods
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseurl");
		
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("URL Is Not Specified In Config File");
			
			
		}
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
		{
			return value;
		}
		else {
			throw new RuntimeException("Browser Is Not Specified In Config File");
		}
	}
}
