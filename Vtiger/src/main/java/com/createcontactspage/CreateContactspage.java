package com.createcontactspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactspage {

	public CreateContactspage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text'and@name='firstname']")
	private WebElement FirstNametextbox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement Savebtn;
	
	public WebElement getSavebtn()
	{
		return Savebtn;
	}
	
	@FindBy(xpath="//input[@type='text'and@name='lastname']")
	private WebElement LastNametextbox;
	
	
	public WebElement getFirstNametextbox()
	{
		return FirstNametextbox;
	}
	
	public WebElement getLastNametextbox()
	{
		return LastNametextbox;
	}
	
}
