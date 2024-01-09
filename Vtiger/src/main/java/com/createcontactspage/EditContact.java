package com.createcontactspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContact
{
	
	@FindBy(xpath = "(//a[text()='edit'])[")
	private WebElement Editbtn;
	
	@FindBy(linkText = "ciud")
	private WebElement contName;
	
	

	public EditContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getEditbtn() {
		return Editbtn;
	}
	
	public WebElement getContName() {
		return contName;
	}


}
