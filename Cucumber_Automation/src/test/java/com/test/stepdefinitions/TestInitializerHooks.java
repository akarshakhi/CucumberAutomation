package com.test.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.base.BaseInitialiser;
import com.test.base.BrowserFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestInitializerHooks extends BaseInitialiser{
	
	public static Scenario sc;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		String browserName = "chrome";
		driver = BrowserFactory.createWebDriver(browserName);
		driver.manage().deleteAllCookies();
		sc = scenario;
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "-");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	public static void takeScreenshot() {
		String screenshotName = sc.getName().replaceAll(" ", "-");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourcePath, "image/png", screenshotName); 
	}

}
