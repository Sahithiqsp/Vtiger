package com.vtigerLoginpages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.Iconstant;
	import com.vtiger.genericlib.PropertyUtility;
	import com.vtiger.genericlib.WebDriverUtility;

	public class LoginandLogoutPages extends BaseClass {
		@FindBy(name="user_name")
		private WebElement untab;
		
		@FindBy(name="user_password")
		private WebElement pwdtab;
		
		@FindBy(id="submitButton")
		private WebElement loginbtn;
		
		@FindBy(xpath = "//td[@class='genHeaderSmall']/following-sibling::td/img")
		private WebElement adminimage;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signout;
		
	  
		

		public WebElement getAdminimage() {
			return adminimage;
		}

		
		


		public WebElement getSignout() {
			return signout;
		}





		public LoginandLogoutPages(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}
		
		public WebElement getUntab() {
			return untab;
		}

		public WebElement getPwdtab() {
			return pwdtab;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
		//business libraries
		
		public void createloginpage() throws Throwable
		{
			pu= new PropertyUtility();
			getUntab().sendKeys(pu.fetchPropertyfile(Iconstant.VtigerLogin, "un"));
			getPwdtab().sendKeys(pu.fetchPropertyfile(Iconstant.VtigerLogin, "pwd"));
			getLoginbtn().click();
			
		}
		
		public void logoutVtiger()
		{
			wu = new WebDriverUtility();
			wu.moveCursor(Driver.driver, signout);
			getSignout().click();
		}
		
		
		
		

	}

