package com.banking.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.banking.automation.config.ConfigurationUtils;
import com.banking.automation.enviroment.EnviromentUtils;
import com.banking.automation.pages.Dashboard;
import com.banking.automation.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	 protected WebDriver driver;
	 String browserName;
	 public static ExtentReports extent;
	 public static ExtentTest test;
	 public ITestResult result;
	 
	 LoginPage loginObj;
	 protected Dashboard dbObj;
		

	 static {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			extent = new ExtentReports(EnviromentUtils.getReportPath()+"/test"+formater.format(calendar.getTime())+".html",false);
		}
	 
	 @BeforeTest
	 public void openBrowserAndGoToApplication() throws IOException {
		 browserName = ConfigurationUtils.getValueFromKey("browser");
	     initiateBrowser(browserName);
	     String url = ConfigurationUtils.getValueFromKey("baseUrl");
	     driver.get(url);
	     driver.manage().window().maximize();
	 }
	 
 	@BeforeClass
    public void LoginToApplication() throws IOException {
      String username = ConfigurationUtils.getValueFromKey("username");
      String password = ConfigurationUtils.getValueFromKey("password");
      loginObj = new LoginPage(driver);
      dbObj = loginObj.loginToApplication(username, password);
      
    }
		
 	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}
		
	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

		
	@AfterClass(alwaysRun = true)
	public void endTest() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	  
	    
	
	/**
	 * This function is used for opening the browser.    
	 * @param browser
	 */
    private void initiateBrowser(String browser) {
		if(System.getProperty("os.name").contains("Window")) {
			if(browser.equalsIgnoreCase("firefox")) {
				EnviromentUtils.setFirefoxDriver();
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")) {
				EnviromentUtils.setChromeDriver();
				driver= new ChromeDriver();
			}
		}
	}
    
    /**
     * This function is used for making report content.
     * @param result
     * @throws IOException
     */
    private void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
    
    
    /**
     * This function is used for taking the screenshot when the test case failed.
     * @param imageName
     * @return
     * @throws IOException
     */
    public String getScreenShot(String imageName) throws IOException {
		if(imageName.equals("")) {
			imageName = "blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = EnviromentUtils.getScreenshotPath();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation+"/"+imageName+"_"+formatter.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);
		return actualImageName;
	}
}
