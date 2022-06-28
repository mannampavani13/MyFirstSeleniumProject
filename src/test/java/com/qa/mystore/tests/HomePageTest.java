package com.qa.mystore.tests;
  
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.mystore.pages.LoginPage;
import com.qa.mystore.utils.Constants;

public class HomePageTest extends BaseTest {
	

	@Test(priority=1)
	public void homePageTitleTest(){
		String actTitle=homepage.getHomePageTitle();
		System.out.println("Home Page Title is :"+actTitle);

		//(actTitle,Constants.HOME_PAGE_TITLE);
		//assert.assertEquals(actTitle,Constants.HOME_PAGE_TITLE);
		Assert.assertEquals(actTitle, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void isSignInExistTest(){
		boolean flag=homepage.isSignInExist();
		Assert.assertTrue(flag);
	}
	
	@Test(dependsOnMethods="isSignInExistTest",priority=3)
	public void cickOnSignInTest() {
	loginpage=homepage.doClickSignin();
		

	}
}
