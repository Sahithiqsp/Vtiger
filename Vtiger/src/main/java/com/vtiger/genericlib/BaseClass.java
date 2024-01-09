package com.vtiger.genericlib;


	
	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.createcontactspage.ContactsPage;
import com.createcontactspage.CreateContactspage;
import com.createcontactspage.EditContact;

import com.vtigerHomePage.Homepage;
import com.vtigerLoginpages.LoginandLogoutPages;

	


	public class BaseClass{
		protected WebDriverUtility wu;
		protected PropertyUtility pu;
		protected Homepage hm;
		protected LoginandLogoutPages lp;
		protected  ExcelUtilty eu;
		protected ContactsPage cp;
		protected CreateContactspage ccp;
		protected EditContact ec;
		protected JavaUtility ju;
		
		@BeforeSuite
		public void ConnectJDBC()
		{
			Reporter.log("JDBC Connected",true);
			
		}
		//@Parameters("browser")
		@BeforeClass
		//public void setup(String browser) throws Throwable
		public void setup() throws Throwable
		{
			//Driver.SetDriver(browser);
			Driver.SetDriver("Chrome");
			wu = new WebDriverUtility();
			pu= new PropertyUtility();
			wu.maximize(Driver.driver);
			wu.implicitWait(Driver.driver,1000 );
			wu.openApp(Driver.driver,pu.fetchPropertyfile(Iconstant.VtigerLogin, "url") );
		}
		@BeforeMethod
		public void login() throws Throwable 
		{
			lp=new LoginandLogoutPages(Driver.getDriver());
			lp.createloginpage();
			
		}
		
		@AfterMethod
		public void logout() 
		{
			
			lp=new LoginandLogoutPages(Driver.driver);
			wu = new WebDriverUtility();
			wu.moveCursor(Driver.driver,lp.getAdminimage());
			lp.logoutVtiger();
			
			
		}
		@AfterClass
		public void tearup()
		{
			Driver.driver.quit();
		}
		
		@AfterSuite
		public void disconnectJDBC()
		{
			Reporter.log("Disconnect JDBC",true);
		}

	}
	


