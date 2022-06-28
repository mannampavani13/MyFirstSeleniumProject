package com.qa.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.mystore.utils.Constants;

public class MyAccountPageTest extends BaseTest{

	@BeforeClass
	public void accountPageSetUp() {
		loginpage=homepage.doClickSignin();
		myaccountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void myAccountPageNameTest() {
		String name=myaccountpage.getAccountName();
		Assert.assertEquals(name, "Pavani Mannam");
	}
	
	@Test(priority=2)
	public void isSignOutExistTest() {
		    Assert.assertTrue(myaccountpage.isSignOutExist());
	}
	
	@Test(priority=3)
	public void isWomenLinkExistTest() {
		Assert.assertTrue(myaccountpage.isWomenLinkExist());
	}
	@Test(priority=4)
	public void isDressesLinkExisteTest() {
		Assert.assertTrue(myaccountpage.isDressesLinkExist());
	}
	@Test(priority=5)
	public void isTshirtsLinkExisteTest() {
		Assert.assertTrue(myaccountpage.isTShirtsExist());
	}
	
	@DataProvider
	public Object[][] productData(){
		return new Object[][] {
			{"Dresses"},
			{"T-shirts"}
		};
	}
	@Test(priority=6,dataProvider="productData")
	public void doSearchTest(String productName) {
		searchproductslistpage= myaccountpage.doSearch(productName);
		Assert.assertTrue(searchproductslistpage.getproductsListCount()>0);	
		int productsListSize=searchproductslistpage.getproductsListCount();
		System.out.println(productsListSize);
	}
	
	@DataProvider
	public Object[][] selectProductData(){
		return new Object[][] {
			{"Dresses","Printed Summer Dress"},
			{"T-shirts","Faded Short Sleeve T-shirts"}
		};
	}
	
	@Test(priority=7,dataProvider="selectProductData",enabled=false)
	public void selectProductTest(String productName,String mainProductName) {
		searchproductslistpage= myaccountpage.doSearch(productName);
		productinfopage=searchproductslistpage.selectProduct(mainProductName);
		Assert.assertEquals(productinfopage.getproductHeader(), mainProductName);
	 
	}
	
	
	@Test(priority=8,dataProvider="selectProductData")
	public void addToCartTest(String productName,String mainProductName) {
		searchproductslistpage= myaccountpage.doSearch(productName);
		productinfopage=searchproductslistpage.selectProduct(mainProductName);
		productinfopage.doClickOnAddToCart();
	
	}
	
	
}
