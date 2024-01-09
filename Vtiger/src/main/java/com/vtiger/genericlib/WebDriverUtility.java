package com.vtiger.genericlib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * 
	 * @param driver It is variable which will initialized with BaseCass WebDriver ref Variable
	 * This method is used to minimize the browser
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	/**
	 * 
	 * @param driver It is variable which will initialized with BaseCass WebDriver reference Variable
	 * This method is used to maximize the browser
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * 
	 * @param driver It is variable which will intilised with BaseCass WebDriver ref Variable
	 * This method is used to refresh the browser
	 */
	public void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * 
	 * @param driver It is variable which will intilised with BaseCass WebDriver ref Variable
	 * This method is used to back in a WebPage
	 */
	public void backWard(WebDriver driver)
	{
		driver.navigate().back();
	}
	/**
	 * This Method is used to give the application url.
	 * @param driver
	 * @param URL
	 */
	public void appUrl(WebDriver driver,String URL)
	{
	  driver.get(URL);	
	}
	/**
	 * 
	 * @param driver It is variable which will intilised with BaseCass WebDriver ref Variable
	 * This method is used to perform location actrion
	 * And By using this we can write the datain WebPage
	 */
	public void xpathAction(WebDriver driver,By b,String data)
	{
		driver.findElement(b).sendKeys(data);
		
	}
	/**
	 * 
	 * @param driver It is variable which will intilised with BaseCass WebDriver ref Variable
	 * This method is used to perform location actrion
	 * And By using this we can write the datain WebPage
	 */
	public void xpathActionClick(WebDriver driver,By b)
	{
		driver.findElement(b).click();
		
	}
	/**
	 * 
	 * @param driver It is variable which will intilised with BaseCass WebDriver ref Variable
	 * This method is used to perform location actrion
	 * And By using this we can write the datain WebPage
	 */
	public String xpathActionToFetchDatak(WebDriver driver,By b)
	{
		return driver.findElement(b).getText();
		
	}
	/**
	 * This method is used to inspect the multiple elements
	 * at a time.
	 * @param driver
	 * @param b
	 * @return
	 */
	

	public List<WebElement> multipleElementAction(WebDriver driver,By b)
	{
		return driver.findElements(b);
		
	}
	/**
	 * This Method is use to Validate the messages displayed in 
	 * webpage whenever we perform some operation.
	 * @param ele
	 * @return
	 */

	public boolean displayValidation(WebElement ele)
	{
	              
		return ele.isDisplayed();
	}
	/**
	 * This method is used to validate the  checkbox is selected or not.
	 * @param ele
	 * @return
	 */
	public boolean selectValidation(WebElement ele)
	{
		return ele.isSelected();
	}
	/**
	 * This method is used to validate the HTML attribute is enabled or not.
	 * @param ele
	 * @return
	 */
	public boolean enabledValidation(WebElement ele)
	{
		return ele.isEnabled();
	}
	/**
	 * This Method is used to return the H-over message  
	 * @param ele
	 * @param aN
	 * @return
	 */

    public String hoverMsg(WebElement ele,String aN)
    {
    	  return ele.getAttribute(aN);
    }
    /**
     * This method is used to Scrolldown in the Webpage
     * @param driver
     * @param ele
     */
    
    public void scrollPage(WebDriver driver,WebElement ele)
    {
    	JavascriptExecutor jse =(JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true)",ele);
    }
    /**
     * This Method is used to right click on the particular element.
     * @param driver
     * @param ele
     */
    public void rightClick(WebDriver driver,WebElement ele)
    {
      Actions act =new Actions(driver);	
      act.contextClick(ele).perform();
    }
    /**
     * This Method is used to move the curser to particular element.
     * @param driver
     * @param ele
     */
    public void moveCursor(WebDriver driver,WebElement ele)
    {
    	Actions act =new Actions(driver);	
        act.moveToElement(ele).perform();;
    }
    /**
     * This Method is used to double click on the particular element in webpage.
     * @param driver
     * @param ele
     */
    public void doubleClick(WebDriver driver,WebElement ele)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick(ele).perform();
    }
    /**
     * This method is used to drag and drop the element usin source and Destination.
     * @param driver
     * @param src
     * @param dst
     */
 
    public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(src, dst).perform();
    }
    /**
     * This Method is used to drag and drop the element
     * @param driver
     * @param src
     * @param x
     * @param y
     */
    public void dragAndDrop(WebDriver driver,WebElement src,int x,int y)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDropBy(src, x, y).perform();
    }
    /**
     * This Method will wait for num seconds for all the Web elements to load.
     * @param driver
     * @param num
     */
    public void implicitWait(WebDriver driver,int num)
    {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
    /**
     * This Method handle the static Dropdown by using index value.
     * @param ele
     * @param num
     */
    public void handleDropdown(WebElement ele,int index)
    {
    	Select s=new Select(ele);
    	s.selectByIndex(index);
    }
    /**
     * This Method will handle the static dropdown by using String 
     * @param ele
     * @param value
     */
    
    public void handleDropdown(WebElement ele,String value)
    {
    	Select s=new Select(ele);
    	s.selectByValue(value);
    }
    /**
     * This Method will handle the static dropdown by using text.
     * @param ele
     * @param text
     */
    public void handlestatiDropdown(WebElement ele,String text)
    {
    	Select s=new Select(ele);
    	s.selectByVisibleText(text);
    }
    /**
     * This Method will handle the frame popup using index value.
     * @param driver
     * @param index
     */
    public void frame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
   /**
    * This Method will handle or enter the Frame pop up using Webelement.
    * @param driver
    * @param frameElement
    */
    public void frame(WebDriver driver,WebElement frameElement)
    {
    	driver.switchTo().frame(frameElement);
    }
    /**
     * This Method will handle or enter the Frame pop up using String name
     * @param driver
     * @param name
     */
    public void frame(WebDriver driver,String name)
    {
    	driver.switchTo().frame(name);
    }
    /**
     * This Method is used to handle window Pop up 
     * @param driver
     */
	/*
	 * public void windowPop(WebDriver driver) { String id=driver.getWindowHandle();
	 * driver.switchTo().window(id); }
	 */
    /**
     * This Method is used to switch To particular window.
     * @param driver
     * @param data
     */
    public void windowpopup(WebDriver driver,String title)
    {
    	Set<String> allId=driver.getWindowHandles();
        for(String i:allId)
        {
        	String s=driver.switchTo().window(i).getTitle();
        	if(s.contains(title))
        	{
        		break;
        	}
        }
    }
    /**
     * This Method is used to Take Screenshot
     * @param driver
     * @param path
     * @throws IOException
     */
    public void screenShot(WebDriver driver,String path) throws IOException
    {
    	TakesScreenshot sh=(TakesScreenshot)driver;
    	File src=sh.getScreenshotAs(OutputType.FILE);
    	File dest=new File(path+".png");
    	Files.copy(src, dest);
    }
    /**
     * This Method is used to click on accept button in alert popup.
     * @param driver
     */
    public void acceptAlertPopup(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /**
     * This method is used to click on cancel button in Alert Pop up.
     * @param driver
     */
    public void dismisstAlertPopup(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();;
    }
    /**
     * This Method is used print the text of alert pop up in console.
     * @param driver
     */
    public String printAlertPopup(WebDriver driver)
    {
    	String data=driver.switchTo().alert().getText();
    	return data;
    }
    /**
     * This Method is used to write the data in to the Alert Pop up.
     * @param driver
     * @param data
     */
    public void writeAlertPopup(WebDriver driver,String data)
    {
    	driver.switchTo().alert().sendKeys(data);;
    }
    
    /**
     * This method is used to open the browser
     */
   public void openApp(WebDriver driver,String url)
   {
	   driver.get(url);
   }
}

