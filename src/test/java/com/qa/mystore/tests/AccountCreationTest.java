package com.qa.mystore.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseTest{

	@BeforeClass
	public void loginPageSetUp() {
		loginpage=homepage.doClickSignin();
		accountcreation=loginpage.clickOnCreateAccountbtn("xyz950@gmail.com");
	}
	
	
	@Test
	public void registerTest() {
		accountcreation.accountRegistration("Mrs", "pavani", "mannam", "pavani123", 
				"13", "April", "1992", "pavani", "mannam", "pavanimannam", 
				"hitech city", "hyderbad", "Alabama", "00023", 
				"United States", "950237", "9502379272", "write something");
	}
	
	
}
