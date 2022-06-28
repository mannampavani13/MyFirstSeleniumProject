package com.qa.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.mystore.utils.Constants;
import com.qa.mystore.utils.ElementUtil;


public class HomePage{
//1.create private webdriver
	
	private WebDriver driver;
	
	private ElementUtil eleUtil;
	//2.Create HomePage Constructor
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	//3.Create private By Locators
	private By signIn = By.xpath("//a[@class='login']");
	
	
	//4. Create Page Action methods
	
	public String getHomePageTitle(){
		return eleUtil.doGetTitle(Constants.HOME_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isSignInExist(){
		return eleUtil.doIsDisplayed(signIn);
	}
	
	public LoginPage doClickSignin(){
		eleUtil.doClick(signIn);
		return new LoginPage(driver);
	}
}
