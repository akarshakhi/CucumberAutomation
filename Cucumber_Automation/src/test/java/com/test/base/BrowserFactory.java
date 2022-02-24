package com.test.base;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;

	public static void openBrowser(String browserType) {
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			String downloadFilePath = System.getProperty("user.dir" + "\\downloads");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilePath);
			chromePrefs.put("profile.defaut_content_setting_values.notifications", 2);
			chromePrefs.put("safebrowsing.enabled", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--ignore-ceertificate-errors");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
			break;
		default:
			System.out.println("provide valid browser name");
			break;

		}

	}

	public static WebDriver createWebDriver(String browserName) {
		try {
				BrowserFactory.destroyDriver();
				Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			openBrowser(browserName);
			System.out.println("browser instance created");
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void destroyDriver() {
		if(driver != null) {
			driver.quit();
			driver=null;
		}
		System.gc();
	}
	
	public static void openBrowserNew(String browserType) {
		switch(browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Invalid browser details");
			break;
		}
	}

}
