package org.cts.pun.sba.utils;

import static org.cts.pun.sba.utils.ReadPropertyFile.prop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.log4testng.Logger;

public class BaseTest {

	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(BaseTest.class);

	public WebDriver getWebDriver(String browser) {

		if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriverPath"));
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(cap);
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			logger.warn("Invalid Browser Selection. Please choose from IE|chrome|firefox");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);

		return driver;
	}

	public void launchApplication(String url) {
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
