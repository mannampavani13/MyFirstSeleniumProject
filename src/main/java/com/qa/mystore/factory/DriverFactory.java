package com.qa.mystore.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory{
	public WebDriver driver;  
	public Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;  
	public static ThreadLocal<WebDriver> t1Driver = new ThreadLocal<WebDriver>();
	
	
	
	public WebDriver init_driver(Properties prop){ 
		String browserName=prop.getProperty("browser").trim();
		System.out.println("Browser Name is :" + browserName);
		highlight=prop.getProperty("highlight");
		optionsManager =new OptionsManager(prop);
		if(browserName.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			t1Driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Safari")){
		
			driver= new SafariDriver();
		}
		
		else{
			System.out.println("Please pass the right browser");
		}
	
	
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
	
	return getDriver();
	
	}
	
	public static synchronized WebDriver getDriver() {
		return t1Driver.get();
	}
	
	
	
	
	
	/**
	 * This method will intialise the Properties
	 * @return Properties
	 */
	
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prop;
	}
	
}
