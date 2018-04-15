package org.cts.pun.sba.pageobjects;

import org.cts.pun.sba.utils.Driver;
import org.openqa.selenium.WebDriver;

public class HomePage extends Driver {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private String SRC = "//*[@id='src']";
	private String DEST = "//*[@id='dest']";
	private String ONWARD_DATE = "//label[@for='onward_cal']";
	private String RETURN_DATE = "//label[@for='return_cal']";
	private String SET_DAY = "//div[@class='rb-calendar']//td[text()='%s']";
	private String GET_MONTH_YEAR = "//div[@class='rb-calendar']//td[@class='monthTitle']";
	// private String NEXT="//div[@class='rb-calendar']//td[@class='next']/button";
	private String SEARCH_BUSES = "//button[@id='search_btn']";

	public HomePage setSource(String src) {
		setValue(SRC, src);
		return this;
	}

	public HomePage setDestination(String dest) {
		setValue(DEST, dest);
		return this;
	}

	private String getMonthYearFromCalendar() {
		return getText(GET_MONTH_YEAR);
	}

	private void selectDay(String day) {
		clickElement(String.format(SET_DAY, day));
	}

	public HomePage selectOnwardDate(String date) {
		clickElement(ONWARD_DATE);
		String[] dateArray = date.split("-");
		if (getMonthYearFromCalendar().equals(dateArray[1])) {
			selectDay(dateArray[0]);
		}
		return this;
	}

	public HomePage selectReturnDate(String date) {
		clickElement(RETURN_DATE);
		String[] dateArray = date.split("-");
		if (getMonthYearFromCalendar().equals(dateArray[1])) {
			selectDay(dateArray[0]);
		}
		return this;
	}

	public void searchBuses() {
		clickElement(SEARCH_BUSES);
	}

}
