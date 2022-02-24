package com.test.testrunner;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(features="src/test/resources/features",
glue="com.test.stepdefinitions", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class BaseRunner extends AbstractTestNGCucumberTests{
	
	@Parameters({"browserName"})
	@BeforeTest
	public void setEnvDetails(@Optional("Chrome") String browserName) {
		String dir = System.getProperty("user.dir")+"\\Reports";
		File file = new File(dir);
		for(File f: file.listFiles()) {
			if(f.getName().endsWith(".png")) {
				f.delete();
			}
		}
		//PropHolder.setBrowserName(browserName);
		//ConfigHelper.getInstance();
	}
}
