package com.qa.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.mystore.utils.Constants;
import com.qa.mystore.utils.ElementUtil;

public class MyAccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);	
	}
	
	private By accountName = By.xpath("//a[@title='View my customer account']");
	private By signOut = By.xpath("//a[@class='logout']");
	private By Women=By.xpath("(//a[@title='Women'])[1]");
	private By Dresses =By.xpath("(//a[@title='Dresses'])[2]");
	private By TShirts =By.xpath("(//a[@title='T-shirts'])[2]");
	private By printedDress=By.xpath("(//img[@title='Printed Dress'])[2]");
	private By searchField=By.xpath("//input[@id='search_query_top']");
	private By doSearchClick = By.xpath("//button[@type='submit' and @name='submit_search']");
	
	
	public String doGetMyAccountPageTitle() {
	return	eleUtil.doGetTitle(Constants.ACCOUNTS_PAGE_HEADER, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountName() {
	return	eleUtil.doGetText(accountName);
	}
	
	public boolean isSignOutExist() {
	return	eleUtil.doIsDisplayed(signOut);
	}
	
	public boolean isWomenLinkExist() {
		return eleUtil.doIsDisplayed(Women);
	}
	
	public boolean isDressesLinkExist() {
		return eleUtil.doIsDisplayed(Dresses);
	}
	
	public boolean isTShirtsExist() {
		return eleUtil.doIsDisplayed(TShirts);
	}
	
	
	public void doSignOut() {
		eleUtil.doClick(signOut);
	}
	
	public SearchProductsListPage doSearch(String productName) {
		eleUtil.doSendKeys(searchField, productName);
		eleUtil.doClick(doSearchClick);
		return new SearchProductsListPage(driver);
	}
	
	
	
	
	
}
