package com.banking.automation.enviroment;

public class EnviromentUtils {
	
	/**
	 * This function is used for getting the current project path
	 * @return the project path
	 */
	public static String getCurrentProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static String getMainResourcePath() {
		return getCurrentProjectPath()+"/src/main/resources";
	}
	
	public static String getMainJavaPath() {
		return getCurrentProjectPath()+"/src/main/java";
	}
	
	public static String getTestResourcePath() {
		return getCurrentProjectPath()+"/src/test/resources";
	}
	
	public static String getReportPath() {
		return getMainJavaPath() + "/com/banking/automation/reports";
	}
	
	public static String getScreenshotPath() {
		return getMainJavaPath() + "/com/banking/automation/screenshots";
	}
	
	public static void setFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", getMainResourcePath()+"/Drivers/geckodriver.exe");
	}
	
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", getMainResourcePath()+"/Drivers/chromedriver.exe");
	}
	
}
