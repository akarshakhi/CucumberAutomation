package com.test.stepdefinitions;

import com.test.scripts.LoginAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {
	
	@Given("^User is on Welcome Page$")
	public void user_on_welcome_page() {
		LoginAction.homepage();
	}

	@When("User Entered {string} and {string}")
	public void user_entered_and(String string, String string2) {
	    LoginAction.login(string, string2);
	    
	}
}
