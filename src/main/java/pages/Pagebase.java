package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Pagebase {


	protected WebDriver driver;


	//Create Constructor
	public Pagebase(WebDriver driver)
	{

		//Page Factory its a class already exists in the Selenium Library is responsible for initating the web elements
		PageFactory.initElements(driver, this);	
	}
	
	
	protected static void clickbutton(WebElement button)
	{
	
		button.click();
	}
	
	protected static void Entertxt(WebElement txtelement,String value)
	{
		
		txtelement.sendKeys(value);
	}

}
