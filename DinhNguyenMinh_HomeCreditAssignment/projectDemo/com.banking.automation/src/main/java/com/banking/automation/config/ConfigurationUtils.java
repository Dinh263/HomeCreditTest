package com.banking.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.banking.automation.enviroment.EnviromentUtils;



public class ConfigurationUtils {
	public static Properties getProperty() throws IOException {
		Properties prop = new Properties();
		String fileProperty =EnviromentUtils.getMainResourcePath()+"/config/config.properties";
		InputStream inputStr = new FileInputStream(fileProperty);
		prop.load(inputStr);
		return prop;
		
	}
	
	public static String getValueFromKey(String key) throws IOException {
		Properties prop = ConfigurationUtils.getProperty();
		return prop.getProperty(key);
	}
}
