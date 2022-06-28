package com.qa.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.mystore.utils.Constants;

public class LoginPageTest extends BaseTest {

	@BeforeClass
	public void loginPageSetUp() {
		loginpage=homepage.doClickSignin();
	}
	
	@Test(priority=1)
	public void getLoginPageTitleTest() {
		String actTitle=loginpage.getLoginPageTitle();
		System.out.println("Login page title is :" + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void isSignInbtnExistTest() {
	 boolean flag= loginpage.isSignInbtnExist();
	 Assert.assertTrue(flag);
	 
	}
	@Test(priority=3)
	public void isForgotPasswordExistTest() {
		boolean flag= loginpage.isForgotPasswordExist();
		 Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void isCreateAnAccoutbtnExistTest() {
		boolean flag=loginpage.isCreateAnAccoutbtnExist();
		Assert.assertTrue(flag);
	}
	@Test(enabled=false)
	public void clickOnCreateAccountbtnTest() {
		loginpage.clickOnCreateAccountbtn("xyz@gmail.com");
	}

	@Test(priority=5)
	 public void doLoginTest() {
		myaccountpage= loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		String actTitle=myaccountpage.doGetMyAccountPageTitle();
		Assert.assertEquals(actTitle,Constants.ACCOUNTS_PAGE_HEADER);	 
	
	}
	
	


}
