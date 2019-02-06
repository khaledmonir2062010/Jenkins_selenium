package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage_Page;
import pages.Login_Page;
import pages.UserRegisteration_Page;

public class UserRegisteration_test2_DDT_ExcelFile extends TestBase
{

	HomePage_Page homeobject;
	UserRegisteration_Page Registerobject;
	Login_Page LoginObject;

	
	//read From EXCELREADER Class
	@DataProvider(name="ExceData")
	public Object[][] userregData() throws IOException
	{
		//Read From Excel reader Class
		ExcelReader ER=new ExcelReader();
		
			return ER.getExceData();
	}

	@Test(priority=1,alwaysRun=true,dataProvider="ExceData")
	public void UserCanRegisterSuccessfully(String fname,String lName, String Email, String pass, String conPAss)
	{
		//This to call the OpenregisterPage method from the Home page class object
		homeobject = new HomePage_Page(driver);
		homeobject.openRegisterPage();



		//This is to call the userRegisteration method from the user registration page class object
		Registerobject =new UserRegisteration_Page(driver);
		Registerobject.userRegisteration(fname, lName, Email, pass, conPAss);

		//Assert that user register successfully so the login link will be displayed

		Assert.assertTrue(Registerobject.sucessmessage.getText().contains("Your registraction completed"));

		Registerobject.userlogOut();
		Assert.assertTrue(Registerobject.LogoutAssertionMsg.getText().contains("Welcome to our store"));
		
		
		homeobject.openLoginPage();
		LoginObject =new Login_Page(driver);
		LoginObject.UserLogin(Email, pass);
		Assert.assertTrue(Registerobject.LogoutLink.isDisplayed());
		Registerobject.userlogOut();
		
		
	}
}
