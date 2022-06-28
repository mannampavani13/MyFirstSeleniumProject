package com.qa.mystore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.mystore.utils.Constants;
import com.qa.mystore.utils.ElementUtil;

public class SearchProductsListPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productsList = By.cssSelector("div.product-container a.product_img_link");
	
	public SearchProductsListPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}

	public String doGetSearchResultsPageTitle() {
		return eleUtil.doGetTitle(Constants.SEARCH_RESULTS_PRODUCTSLIST_TITLE, Constants.DEFAULT_TIME_OUT);
		
	}
	
	public int getproductsListCount() {
	int	resultcount =eleUtil.waitForElementsToBeVisible(productsList, 10, 2000).size();
		System.out.println("the search product count :"+resultcount);
		return resultcount;
	}
	
	public productInfoPage selectProduct(String mainProductName) {
		
		System.out.println("select the dress : "+mainProductName);
		List<WebElement> searchList=eleUtil.waitForElementsToBeVisible(productsList, 10, 2000);
		for(WebElement e:searchList) {
			String text=e.getText();
			if(text.equalsIgnoreCase(mainProductName)) {
				e.click();
				break;
			}
		}
		return new productInfoPage(driver);
	}
	
	
}
