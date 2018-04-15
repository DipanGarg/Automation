package org.cts.pun.sba.tests;

import java.util.HashMap;

import org.cts.pun.sba.pageobjects.HomePage;
import org.cts.pun.sba.utils.BaseTest;
import org.cts.pun.sba.utils.DateUtils;
import org.cts.pun.sba.utils.ReadExcel;
import org.cts.pun.sba.utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicket extends BaseTest {

	private WebDriver driver;
	private HomePage homePage;
	private ReadExcel input;
	private HashMap<String, String> excel= new HashMap<String, String>();

	@BeforeMethod
	public void init() {
		driver = getWebDriver(ReadPropertyFile.getBrowser());
		homePage = PageFactory.initElements(driver, HomePage.class);
		input = new ReadExcel("BookTicket");
		excel= input.readExcel();
	}

	@Test
	public void bookTicketTest() {

		launchApplication(ReadPropertyFile.getUrl());

		homePage.setSource(excel.get("from"))
		.setDestination(excel.get("to")).
		selectOnwardDate(DateUtils.getCurrentDate())
		.selectReturnDate(DateUtils.getTomorrowDate())
		.searchBuses();;

	}

}
