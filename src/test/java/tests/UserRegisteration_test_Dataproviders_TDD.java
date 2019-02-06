package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage_Page;
import pages.Login_Page;
import pages.UserRegisteration_Page;

public class UserRegisteration_test_Dataproviders_TDD extends TestBase
{

	HomePage_Page homeobject;
	UserRegisteration_Page Registerobject;
	Login_Page LoginObject;


	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		//This to call the OpenregisterPage method from the Home page class object
		homeobject = new HomePage_Page(driver);
		homeobject.openRegisterPage();



		//This is to call the userRegisteration method from the user registration page class object
		Registerobject =new UserRegisteration_Page(driver);
		Registerobject.userRegisteration("Khaled", "Monir", "1222Emeaile1222333933@yahoo.com", "123456", "123456");

		//Assert that user register successfully so the login link will be displayed

		Assert.assertTrue(Registerobject.sucessmessage.getText().contains("Your registration completed"));

	}

	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisteredUsercanLogOut() {

		Registerobject.userlogOut();

		Assert.assertTrue(Registerobject.LogoutAssertionMsg.getText().contains("Welcome to our store"));

	}

	@Test(dependsOnMethods= {"RegisteredUsercanLogOut"})
	public void Registered_User_Can_Login()
	{
		homeobject.openLoginPage();
		LoginObject =new Login_Page(driver);
		LoginObject.UserLogin("1222Emeaile1222333933@yahoo.com", "123456");
		Assert.assertTrue(Registerobject.LogoutLink.isDisplayed());
	}


}
