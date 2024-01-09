package com.vtiger.Testcases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.createcontactspage.CreateContactspage;
import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.ExcelUtilty;
import com.vtiger.genericlib.Iconstant;
import com.vtiger.genericlib.JavaUtility;
import com.vtigerHomePage.Homepage;



public class CreateContactwithName extends BaseClass {
	
	private CreateContactwithName()
	{
		
	}
	@Test
	
	public void m1() throws Throwable
	{
		eu=new ExcelUtilty();
		ju=new JavaUtility();
		hm=new Homepage(Driver.getDriver());
		ccp=new CreateContactspage(com.vtiger.genericlib.Driver.driver);
		hm.getContactsbtn().click();
		cp.getPlus().click();
		int num=ju.randomNumberGenrate(1000);
		ccp.getFirstNametextbox().sendKeys(eu.fetchSingleDataFromExcel(Iconstant.excelpath1, "Sheet1", 1, 3));
		ccp.getSavebtn().click();
		
	}

}
