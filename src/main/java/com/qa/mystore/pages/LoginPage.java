package com.qa.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.mystore.utils.ElementUtil;

public class LoginPage{

	private WebDriver driver;
	private ElementUtil eleUtil;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	By signInbtn = By.xpath("//i[@class='icon-lock left']/..");
	By forgotPassword =By.linkText("Forgot your password?");
	By createAnAccountbtn=By.id("SubmitCreate");
	By emailId= By.id("SubmitCreate");
	By emailAddress = By.id("email");
	By password =By.id("passwd");
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isSignInbtnExist() {
		return eleUtil.doIsDisplayed(signInbtn);
	}
	
	public boolean isForgotPasswordExist() {
	   return	eleUtil.doIsDisplayed(forgotPassword);
	}
	
	public boolean isCreateAnAccoutbtnExist() {
		return eleUtil.doIsDisplayed(createAnAccountbtn);
	}
	
	public AccountCreation clickOnCreateAccountbtn(String un) {
		eleUtil.doSendKeys(emailId, un);
		Actions act = new Actions(driver);
		act.click(eleUtil.getElement(createAnAccountbtn)).build().perform();
		
		
		return new AccountCreation(driver);
	}
	
	public MyAccountPage doLogin(String un, String pwd) {
	eleUtil.doSendKeys(emailAddress, un);
	eleUtil.doSendKeys(password, pwd);
	eleUtil.doClick(signInbtn);
	
	return new MyAccountPage(driver);
	}
}
