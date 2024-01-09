package com.vtiger.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private Driver()
	{
		
	}
	
	public static WebDriver driver;
	static ThreadLocal<WebDriver> tr=new ThreadLocal();
	
	public static void setDriver1(WebDriver driver)
	{
		tr.set(driver);
	}
 public static WebDriver getDriver()
 {
	 return tr.get();
 }
 
 
 public static void SetDriver(String browser)
 {
	 if(browser.equals("Chrome"))
	 {
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 setDriver1(driver);
 }

 if(browser.equals("Edge"))
 {
		 WebDriverManager.edgedriver().setup();
		 driver= new EdgeDriver();
		 setDriver1(driver);
	 
 }
}
}
