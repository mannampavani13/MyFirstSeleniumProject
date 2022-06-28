package com.qa.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.mystore.utils.ElementUtil;

public class productInfoPage{

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productHeader = By.xpath("//div[@class='row']//div[@class='pb-center-column col-xs-12 col-sm-4']/h1");
	private By addToCartBtn = By.xpath("//button[@type='submit' and @name='Submit']");
	private By continueShoppingBtn= By.xpath("//span[@title='Continue shopping']");
	
	public productInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	public String getproductHeader() {
		 return  eleUtil.doGetText(productHeader);
	}
	
	public void doClickOnAddToCart() {
		eleUtil.doClick(addToCartBtn);
		eleUtil.doActionMoveToElementClick(continueShoppingBtn);
		
	}
	
	
}
