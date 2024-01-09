package com.vtiger.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.createcontactspage.ContactsPage;
import com.createcontactspage.CreateContactspage;

import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.ExcelUtilty;
import com.vtiger.genericlib.Iconstant;
import com.vtigerHomePage.Homepage;

@Listeners(com.vtiger.genericlib.Listner.class)

public class ContactsTest extends BaseClass {
	@Test
	public void createcontact() throws Throwable {
		hm= new Homepage(Driver.getDriver());
		eu=new ExcelUtilty();
		cp=new ContactsPage(Driver.getDriver());
		ccp= new CreateContactspage(Driver.getDriver());
		
		hm.getContactsbtn().click();
		cp.getPlus().click();
		
		String data=(eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",1,3));
		System.out.println(data);
		
		ccp.getFirstNametextbox().sendKeys(eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",1,3));
		
		ccp.getLastNametextbox().sendKeys(eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",4,3));
		Thread.sleep(1000);
		
		ccp.getSavebtn().click();
		
	}

}
