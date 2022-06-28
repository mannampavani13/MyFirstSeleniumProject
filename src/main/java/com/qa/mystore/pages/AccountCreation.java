package com.qa.mystore.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.mystore.utils.ElementUtil;

	
public class AccountCreation {
		
		private WebDriver driver;
		private ElementUtil eleUtil;
		
		public AccountCreation(WebDriver driver) {
			this.driver=driver;
			eleUtil=new ElementUtil(driver);
		}

	private By gender_Mr = By.xpath("//input[@id='id_gender1']");	
	private By gender_Mrs = By.xpath("//input[@id='id_gender2']");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	private By password = By.id("passwd");
	private By dob_days=By.id("days");
	private By dob_month = By.id("months");
	private By dob_year=By.id("years");
	private By add_firstname = By.id("firstname");
	private By add_lastname = By.id("lastname");
	private By company = By.id("company");
	private By address=By.id("address1");
	private By city=By.id("city");
	private By states= By.id("id_state");
	private By postalcode =By.id("postcode");
	private By countries =By.id("id_country");
	private By homePhone = By.id("phone");
	private By mobilephone = By.id("phone_mobile");
	private By alias= By.id("alias");
	private By register = By.id("submitAccount");
	
	public void accountRegistration(String gender,String firstName,String lastName,String password,String day,
			String month,String year,String add_firstname,
			String add_lastname,String company,String address,
			String city,String state,String postalcode,String country,
			String homePhone,String mobilephone,String alias) {
		
		if(gender.equalsIgnoreCase("Mr")) {
			eleUtil.doClick(gender_Mr);
		}
		else {
			eleUtil.doClick(gender_Mrs);
		}
		
		
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, firstName);
		eleUtil.doSendKeys(this.password, firstName);
		
		Select select= new Select(eleUtil.getElement(dob_days));
		select.selectByValue(day);
		
		Select select1= new Select(eleUtil.getElement(dob_month));
		select1.selectByValue(month);
		
		Select select2= new Select(eleUtil.getElement(dob_year));
		select2.selectByValue(year);
		
		
		eleUtil.doSendKeys(this.add_firstname, add_firstname);
		eleUtil.doSendKeys(this.add_lastname, add_lastname);
		eleUtil.doSendKeys(this.company, company);
		eleUtil.doSendKeys(this.address, address);
		eleUtil.doSendKeys(this.city, city);
		
		Select select4 = new Select(eleUtil.getElement(states));
		select4.selectByValue(state);
		
		eleUtil.doSendKeys(this.postalcode, postalcode);
		
		Select select5 = new Select(eleUtil.getElement(countries));
		select5.selectByValue(country);
		
		eleUtil.doSendKeys(this.homePhone, homePhone);
		eleUtil.doSendKeys(this.mobilephone, mobilephone);
		eleUtil.doSendKeys(this.alias, alias);
		
		eleUtil.doClick(register);
		
	}
	
	
	
		
		
		
		
		
	}


