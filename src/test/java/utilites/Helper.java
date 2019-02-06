package utilites;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//Method to take screenshot if the test case failed
	
	public static void CaptureScreenshot(WebDriver driver, String Screenshotname) 
	{
		
		//put the screenshot in the folder called in screenshot
		Path destination=Paths.get("./screenshots",Screenshotname+".png");
		
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out=new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		
	}

}
