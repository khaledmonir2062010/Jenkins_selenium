package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage_Page;
import pages.Login_Page;
import pages.UserRegisteration_Page;

public class UserRegisteration_testwithDDTandDataProvider extends TestBase
{

	HomePage_Page homeobject;
	UserRegisteration_Page Registerobject;
	Login_Page LoginObject;

	
	//Data Provider Data Driven
	@DataProvider(name="testData")
	public static Object[][] userdata()
	{
		return new Object[][] 
		{
			{"Kh","mo","teeseet@e.com","123456","123456"},
			{"mo","kh","teeseet@ee.com","123456","123456"}
		};
	}

	@Test(priority=1,alwaysRun=true,dataProvider="testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String Password, String conpass)
	{
		//This to call the OpenregisterPage method from the Home page class object
		homeobject = new HomePage_Page(driver);
		homeobject.openRegisterPage();



		//This is to call the userRegisteration method from the user registration page class object
		Registerobject =new UserRegisteration_Page(driver);
		Registerobject.userRegisteration(fname, lname, email, Password, conpass);

		//Assert that user register successfully so the login link will be displayed

		Assert.assertTrue(Registerobject.sucessmessage.getText().contains("Your registration completed"));
		
		
		//logout functionality
		Registerobject.userlogOut();

		Assert.assertTrue(Registerobject.LogoutAssertionMsg.getText().contains("Welcome to our store"));
		
		homeobject.openLoginPage();
		LoginObject =new Login_Page(driver);
		LoginObject.UserLogin(email, Password);
		Assert.assertTrue(Registerobject.LogoutLink.isDisplayed());
		Registerobject.userlogOut();

	}

	
	}
