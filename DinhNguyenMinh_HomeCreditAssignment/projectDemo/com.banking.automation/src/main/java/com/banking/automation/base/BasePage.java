package com.banking.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.banking.automation.libs.WaitUtils;

public abstract class BasePage {
	protected WebDriver driver;
	WaitUtils wait; 
	
	public BasePage(WebDriver driver) throws NumberFormatException, IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils(driver);
	}
	
	
	/**
	 * This function is used for entering text on the element.
	 * @param element
	 * @param value
	 */
	protected void enterTextOnElement(WebElement element, String value) {
		wait.waitForElementIsPresent(element);
		element.sendKeys(value);
	}
	
	/**
	 * This function is used for clicking on the element. 
	 * @param element
	 */
	protected void clickOnElement(WebElement element) {
		wait.waitForElementIsClickAble(element);
		element.click();
	}
	
	/**
	 * This function is used for getting the text of element.
	 * @param element which is to get the text.
	 * @return text of element.
	 */
	protected String getTextOfElement(WebElement element) {
		wait.waitForElementIsPresent(element);
		return element.getText();
	}
	
	/**
	 * This function is used for checking if page contains specific string.
	 * @param text which is used for checking. 
	 * @return true if page contains otherwise false will return.
	 */
	protected boolean pageShouldContain(String text) {
		return driver.getPageSource().contains(text);
	}
	
}
