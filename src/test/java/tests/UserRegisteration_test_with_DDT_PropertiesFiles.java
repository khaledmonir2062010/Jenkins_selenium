package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage_Page;
import pages.Login_Page;
import pages.UserRegisteration_Page;

public class UserRegisteration_test_with_DDT_PropertiesFiles extends TestBase
{

	HomePage_Page homeobject;
	UserRegisteration_Page Registerobject;
	Login_Page LoginObject;
	
	
	//reading data from userdata.properties
	String firstname=LoadProperties.userData.getProperty("Firstname");
	String lname=LoadProperties.userData.getProperty("lName");
	String email=LoadProperties.userData.getProperty("email");
	String password=LoadProperties.userData.getProperty("password");
	String confpass=LoadProperties.userData.getProperty("conpass");


	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		//This to call the OpenregisterPage method from the Home page class object
		homeobject = new HomePage_Page(driver);
		homeobject.openRegisterPage();



		//This is to call the userRegisteration method from the user registration page class object
		Registerobject =new UserRegisteration_Page(driver);
		Registerobject.userRegisteration(firstname, lname, email, password, confpass);

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
		LoginObject.UserLogin(email, password);
		Assert.assertTrue(Registerobject.LogoutLink.isDisplayed());
	}


}
