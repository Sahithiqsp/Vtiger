package com.vtiger.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.createcontactspage.ContactsPage;
import com.createcontactspage.CreateContactspage;
import com.createcontactspage.EditContact;

import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.Driver;
import com.vtiger.genericlib.ExcelUtilty;
import com.vtiger.genericlib.Iconstant;
import com.vtiger.genericlib.JavaUtility;
import com.vtigerHomePage.Homepage;
@Listeners(com.vtiger.genericlib.Listner.class)
public class Edit extends BaseClass {
	@Test
	
	public void contactEdit() throws Throwable {
		eu=new ExcelUtilty();
		ec=new EditContact(Driver.driver);
		ju=new JavaUtility();
		hm= new Homepage(Driver.driver);
		cp=new ContactsPage(Driver.driver);
		ccp=new CreateContactspage(Driver.driver);
		hm.getContactsbtn().click();
		//ec.getContName().click();
		ec.getEditbtn().click();
		
		String data= (eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",7,3));
		System.out.println(data);
        ccp.getFirstNametextbox().sendKeys(eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",1,3));
		
		ccp.getLastNametextbox().sendKeys(eu.fetchSingleDataFromExcel(Iconstant.excelpath1,"Sheet1",4,3));
//		Thread.sleep(1000);
		
		ccp.getSavebtn().click();
	}

}
