package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Pagebase{

	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(id="Email")
	WebElement emailtxtBox;

	@FindBy(id="Password")
	WebElement passwordtxtBox;

	@FindBy(css="input.button-1.login-button")
	WebElement Loginbutton;
	
	
	
	public void UserLogin(String email, String Pass)
	{
		
		Entertxt(emailtxtBox,email);
		Entertxt(passwordtxtBox, Pass);
		clickbutton(Loginbutton);
		
	}

}
