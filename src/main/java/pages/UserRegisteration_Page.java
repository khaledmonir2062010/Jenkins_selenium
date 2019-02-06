package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisteration_Page extends Pagebase {

	public UserRegisteration_Page(WebDriver driver) {
		super(driver);
		
	}
	
	
	//Gender Radio Button
	@FindBy(id="gender-male")
	WebElement Gender;
	
	//UserName field
	@FindBy(id="FirstName")
	WebElement FirstNametxt;
	
	//LastName Field
	@FindBy(id="LastName")
	WebElement LastNametxt;
	
	//Email Field
	@FindBy(id="Email")
	WebElement Emailtxt;
	
	
	//Password Field
	@FindBy(id="Password")
	WebElement passwordtxt;
	
	//confirmPass field
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPasstxt;
	
	//Registration button
	@FindBy(id="register-button")
	WebElement registerbtn;
	
	@FindBy(css="div.result")
	public WebElement sucessmessage;
	
	@FindBy(linkText="Log out")
	public WebElement LogoutLink;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")
	public WebElement LogoutAssertionMsg;
	
	
	public void userRegisteration(String FirstName,String LastName, String Email,String Password,String ConfrimPass)
	{
		//Gender.click();
		//FirstNametxt.sendKeys(FirstName);
		//LastNametxt.sendKeys(LastName);
		//Emailtxt.sendKeys(Email);
		//passwordtxt.sendKeys(Password);
		//ConfirmPasstxt.sendKeys(ConfrimPass);
		//registerbtn.click(); 
		
		clickbutton(Gender);
		Entertxt(FirstNametxt, FirstName);
		Entertxt(LastNametxt, LastName);
		Entertxt(Emailtxt, Email);
		Entertxt(passwordtxt, Password);
		Entertxt(ConfirmPasstxt, ConfrimPass);
		clickbutton(registerbtn);
		
	}
	
	
	public void userlogOut()
	{
		clickbutton(LogoutLink);;
	}
}
