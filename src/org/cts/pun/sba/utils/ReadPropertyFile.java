package org.cts.pun.sba.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class ReadPropertyFile {

	public static Properties prop = new Properties();
	private static FileInputStream input;
	private final static Logger logger = Logger.getLogger(ReadPropertyFile.class);

	static {
		try {
			input = new FileInputStream(Constants.configFilePath);
			prop.load(input);
		} catch (IOException e) {
			logger.warn("Config.properties not found!!!!");
		}
	}

	public static String getUrl() {
		return prop.getProperty("url").trim();
	}

	public static String getBrowser() {
		return prop.getProperty("browser").trim();
	}

	public static String getIEDriverPath() {
		return prop.getProperty("IEDriverPath").trim();
	}

	public static String getChromeDriverPath() {
		return prop.getProperty("chromeDriverPath").trim();
	}

	public static int getTimeOutWait() {
		return Integer.parseInt(prop.getProperty("implicitWait").trim());
	}

}
