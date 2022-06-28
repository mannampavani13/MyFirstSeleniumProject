package com.qa.mystore.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.mystore.factory.DriverFactory;
import com.qa.mystore.pages.AccountCreation;
import com.qa.mystore.pages.HomePage;
import com.qa.mystore.pages.LoginPage;
import com.qa.mystore.pages.MyAccountPage;
import com.qa.mystore.pages.SearchProductsListPage;
import com.qa.mystore.pages.WomenPage;
import com.qa.mystore.pages.productInfoPage;

public class BaseTest{

	DriverFactory df;
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	WomenPage womenpage;
	SearchProductsListPage searchproductslistpage;
	productInfoPage productinfopage;
	AccountCreation accountcreation ;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		womenpage=new WomenPage(driver);
		searchproductslistpage = new SearchProductsListPage(driver);
		accountcreation = new AccountCreation(driver);
		 
		productinfopage = new productInfoPage(driver);
		myaccountpage = new MyAccountPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
