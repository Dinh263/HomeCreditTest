package com.banking.automation.libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownListUtils {
	private WebDriver driver;
	public DropDownListUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
}
