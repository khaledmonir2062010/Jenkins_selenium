package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilites.Helper;

// This class is the responsible for initialise the driver to browser and close the browser 
public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;


	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("Chrome") String BrowserName)
	{
		
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
			
			String ChromePath=System.getProperty("user.dir")+
				"\\Drivers\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver",ChromePath);
			driver =new ChromeDriver();
			
		}
		else if (BrowserName.equalsIgnoreCase("firefox"))
		{
			String FirefoxPath=System.getProperty("user.dir")+
					"\\Drivers\\geckodriver.exe";

			System.setProperty("webdriver.gecko.driver",FirefoxPath);
			driver =new FirefoxDriver();
			
		}
		else if (BrowserName.equalsIgnoreCase("IE"))
		{
			String IEpath=System.getProperty("user.dir")+
					"\\Drivers\\IEDriverServer.exe";

			System.setProperty("webdriver.ie.driver",IEpath);
			driver =new InternetExplorerDriver();
		}
		
		
		/*@BeforeSuite
		public void startDriver()
		{
			String FirefoxPath=System.getProperty("user.dir")+
					"\\Drivers\\geckodriver.exe";

			System.setProperty("webdriver.gecko.driver",FirefoxPath);
			driver =new FirefoxDriver();*/
		
		
		
		
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	
	@AfterSuite
	public void stopDriver()
	{

		driver.quit();	
	}
	
	//take screenshot when test case failed
	@AfterMethod
	public void screenshotonFailure(ITestResult result)
	{
		
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.CaptureScreenshot(driver, result.getName());
		}
	}


}
