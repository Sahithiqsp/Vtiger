package com.vtigerHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
		@FindBy(linkText = "Calendar")
		private WebElement calendarbtn;
		
		@FindBy(linkText = "Leads")
		private WebElement leadsbtn;
		
		@FindBy(linkText = "Organizations")
		private WebElement organizationbtn;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactsbtn;
		
		@FindBy(xpath = "//a[text()='Products']")
		private WebElement productsbtn;
		
		public Homepage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}

		public WebElement getCalendarbtn() {
			return calendarbtn;
		}

		public WebElement getLeadsbtn() {
			return leadsbtn;
		}

		public WebElement getOrganizationbtn() {
			return organizationbtn;
		}

		public WebElement getContactsbtn() {
			return contactsbtn;
		}

		public WebElement getProductsbtn() {
			return productsbtn;
		}

		
		
		
		
		

	}


