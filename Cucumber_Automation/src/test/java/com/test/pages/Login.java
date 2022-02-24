package com.test.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	
	final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public Login(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	//Locating the username text box
	@FindBy(id="txtUsername")
	WebElement username;
	
	//Locating the password text box
	@FindBy(id="txtPassword")
	WebElement pswd;
	
	//Locating Login Button
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public void Navigate_HomePage() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	//Method that performs login action using the web elements
	public void LogIn_Action(String uName, String pwd){
		username.sendKeys(uName);
		pswd.sendKeys(pwd);
		loginBtn.click();
	}
	
	public void Verify_LoginPage() throws InterruptedException {
		driver.close();
	}
}
