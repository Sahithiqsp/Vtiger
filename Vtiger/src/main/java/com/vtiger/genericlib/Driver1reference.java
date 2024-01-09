package com.vtiger.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver1reference {
	private Driver1reference()
	{
		
	}
	public static WebDriver driver;
	
	public static WebDriver setDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}

}
