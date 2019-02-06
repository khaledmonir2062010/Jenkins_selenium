package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Page extends Pagebase {

	public HomePage_Page(WebDriver driver)
	{
		super(driver);
	}
	
	// Find by got injected from the Page factory to initialise the element
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	
	
	
	public void openRegisterPage()
	{
		//registerLink.click(); 
		
		clickbutton(registerLink);
	}
	
	public void openLoginPage()
	{
		
		clickbutton(LoginLink);
		
	}

}
