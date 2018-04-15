package org.cts.pun.sba.tests;

import org.cts.pun.sba.utils.BaseTest;
import org.cts.pun.sba.utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPageTitle extends BaseTest {

	private WebDriver driver;

	@BeforeMethod
	public void init() {
		driver = getWebDriver(ReadPropertyFile.getBrowser());
	}

	@Test
	public void bookTicketTest() {

		launchApplication(ReadPropertyFile.getUrl());
		Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus",
				"APplication launched successfully.");

	}

}
