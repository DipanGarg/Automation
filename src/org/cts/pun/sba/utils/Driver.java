package org.cts.pun.sba.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Driver {

	private WebDriver driver;
	private static int counter=1;

	public Driver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickElement(String element){
		driver.findElement(By.xpath(element)).click();
		Screenshot.captureScreenshot(driver, "Click Action_"+counter++);
	}
	
	public void clearElement(String element){
		driver.findElement(By.xpath(element)).clear();
	}
	
	public void setValue(String element, String value){
		clearElement(element);
		driver.findElement(By.xpath(element)).sendKeys(value);
		Screenshot.captureScreenshot(driver, value);
	}
	
	public String getValue(String element){
		return driver.findElement(By.xpath(element)).getAttribute("value");
	}
	
	public String getText(String element){
		return driver.findElement(By.xpath(element)).getText();
	}
}
