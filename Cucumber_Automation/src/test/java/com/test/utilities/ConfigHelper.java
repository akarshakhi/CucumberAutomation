package com.test.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper {
	
	private static ConfigHelper configHelper;
	private Properties prop = null;
	
	
	private ConfigHelper() {
		
	}
	
	public static ConfigHelper getInstance()
	{
		if(configHelper==null) {
			synchronized (ConfigHelper.class) {
				if(configHelper==null) {
					configHelper = new ConfigHelper();
					configHelper.loadConfigProperties();
				}
			}
		}
		return configHelper;
	}
	private String getConfigFileName() {
		if(PropHolder.getEnvironment()==null) {
			return AppConstants.CONFIG_PATH+AppConstants.CONFIG_FILENAME+AppConstants.PROPERTIES;
		}
		return AppConstants.CONFIG_PATH+AppConstants.CONFIG_FILENAME+PropHolder.getEnvironment()+AppConstants.PROPERTIES;
	}
	
	private void loadConfigProperties() {
		if(prop==null) {
			prop= new Properties();
			try {
				InputStream is = getClass().getResourceAsStream(getConfigFileName());
				prop.load(is);
				is.close();
				System.out.println("Loaded config properties file");
			}catch(FileNotFoundException fnfe) {
				System.out.println(fnfe.getMessage());
				fnfe.printStackTrace();
			}catch(IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public String getConfigProperty(String propName) {
		if(prop!=null) {
			System.out.println("get config for peroperty "+propName);
			String propertyValue= prop.getProperty(propName);
			return propertyValue;
		}
		return null;
	}
	
}
