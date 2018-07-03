package com.banking.automation.libs;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.banking.automation.config.ConfigurationUtils;



public class WaitUtils {
	WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) throws NumberFormatException, IOException {
		int timeout = Integer.parseInt(ConfigurationUtils.getValueFromKey("TimeOutInSecond").toString());
		wait = new WebDriverWait(driver, timeout);
	}
	
	public void waitForElementIsPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void waitForElementIsClickAble(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
