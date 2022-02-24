package com.test.testrunner;

import java.io.File;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.utilities.ConfigHelper;
import com.test.utilities.PropHolder;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@Test
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.test.stepdefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class BaseRunner extends AbstractTestNGCucumberTests{
	
	@Parameters({"browserName","environment"})
	@BeforeTest
	public void setEnvDetails(@Optional("Chrome") String browserName,@Optional("qa") String environment) {
		String dir = System.getProperty("user.dir")+"\\Reports";
		File file = new File(dir);
		for(File f: file.listFiles()) {
			if(f.getName().endsWith(".png")) {
				f.delete();
			}
		}
		PropHolder.setBrowserName(browserName);
		//ConfigHelper.getInstance();
	}
}
