package com.test.scripts;

import com.test.base.BaseInitialiser;
import com.test.pages.Login;

public class LoginAction extends BaseInitialiser {
	static Login loginObject = new Login(driver);

	public static void homepage() {
		loginObject.Navigate_HomePage();
	}


	public static void login(String username, String password) {
		loginObject.LogIn_Action(username, password);
	}
}
