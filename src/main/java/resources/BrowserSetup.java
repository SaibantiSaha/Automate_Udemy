package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("S:\\AutomatingUdemy\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("Browser");
	
	if(browserName.equals("chrome")) 
	{
		System.setProperty("webdriver.chrome.driver","S:\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	if(browserName.equals("firefox")) 
	{
		System.setProperty("webdriver.gecko.driver","S:\\geckodriver.exe");
		 driver=new FirefoxDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
   }
}