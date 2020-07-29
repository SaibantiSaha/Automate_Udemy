package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		try 
		{
			File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
			FileUtils.copyFile(ts, new File(".\\Screenshots\\"+screenshotname+".png"));
			
			//System.out.println("Screenshot taken");
		} 
		
		catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		} 

	}
}
