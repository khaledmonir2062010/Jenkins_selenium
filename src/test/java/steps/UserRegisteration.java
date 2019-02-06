package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage_Page;
import pages.UserRegisteration_Page;
import tests.TestBase;

public class UserRegisteration extends TestBase{
	
	HomePage_Page homeObject;
	UserRegisteration_Page registerobject;
	
	
	@Given("^the user in the home page$")
	public void the_user_in_the_homepage() 
	{
		homeObject =new HomePage_Page(driver);
		homeObject.openRegisterPage();
		
		
	}
	@When("^i click on the register link$")
	public void i_click_on_the_register_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		
		
	}
	
	@When("^i enter the user data$")
	public void i_enter_the_user_data() 
	
	{
		
	}
	@Then("^the registeration should be completed$")
	public void the_registeration_should_be_completed()
	{
		
		
	}
}
