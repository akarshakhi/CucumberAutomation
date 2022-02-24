package com.test.stepdefinitions;

import com.test.scripts.LoginAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {
	
	@Given("^User navigates to home Page$")
	public void User_navigates_to_home_Page() {
		LoginAction.homepage();
	}	
	@When("User Entered Username as {string} and Password as {string}")
	public void user_entered_username_as_and_password_as(String username, String password) throws InterruptedException {
	    LoginAction.login(username, password);
	    Thread.sleep(10);
	}
	@Then("Verify the Login Page")
	public void Verify_the_Login_page() throws InterruptedException {
		LoginAction.verifyLoginPage();	 
		
	}
}
