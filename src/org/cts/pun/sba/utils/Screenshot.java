package org.cts.pun.sba.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class Screenshot {

	private final static Logger logger = Logger.getLogger(Screenshot.class);

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("screenshots"+ "/" + screenshotName + ".png"));
		} catch (IOException e) {
			logger.warn("Not able to capture screenshot");
		}
	}
}
