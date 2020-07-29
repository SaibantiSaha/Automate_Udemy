package MyFirstProject.AutomatingUdemy;


import org.testng.Assert;
import pageObjects.SearchWebDevelopement;
import pageObjects.UdemyPagesFunctionality;
import resources.BrowserSetup;
import resources.CreatingWorkbook;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyFirstProject.AutomatingUdemy.Listeners.class)

public class UdemyTest extends BrowserSetup {
	
	WebDriver driver;
	SearchWebDevelopement obj1;
	UdemyPagesFunctionality obj2;
	
	private static final Logger log = LogManager.getLogger(UdemyTest.class);
	
		
	@BeforeTest
	public void setup() throws IOException
	{
		driver=initializeDriver();
		
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage|| Open UDEMY Page");
		obj2=new UdemyPagesFunctionality(driver);
		obj2.maximizeScreen(driver);
		//log.info("Navigated to homepage");
	}
	
	
	@Test(priority=0)
	public void correctSearchWeb()
	{
		obj1=new SearchWebDevelopement(driver);
		obj1.Search("Web developement");
		boolean currentUrl = driver.getCurrentUrl().contains("Web");
		Assert.assertTrue(currentUrl);
		log.info("Correct course searched");

	}
	
	
	@Test(priority=1)
	public void filterCheckForLevel()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectLevel();
		boolean currentUrl = driver.getCurrentUrl().contains("beginner");
		Assert.assertTrue(currentUrl);
		log.info("Filters applied for level=beginner");

	}
	
	
	@Test(priority=2)
	public void filterCheckForLanguage()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectLanguage();
		boolean currentUrl = driver.getCurrentUrl().contains("lang=en");
		Assert.assertTrue(currentUrl);
		log.info("Filters applied for language=English");
		
	}
	
	
//	@Test(priority = 3)
//	public void Testconsole() 
//	{
//		obj2 = new UdemyPagesFunctionality(driver);
//		obj2.printConsole();
//		boolean currentUrl1 = driver.getCurrentUrl().contains("lang=en");
//		Assert.assertTrue(currentUrl1);
//		log.info("Courses are print in console");
//
//	}
	
	@Test(priority=4)
	public void printConsole() throws IOException
	{

		CreatingWorkbook wb=new CreatingWorkbook(driver);
		wb.creation();
		
		log.info("Available courses printed in FinalOutput.xlxs");
		
	}
	
	
//	NEGATIVE TESTS:-
	
	@Test(priority=5)
	public void wrongSearchWeb()
	{	
		
		obj1=new SearchWebDevelopement(driver);
		obj1.writeJava();
		boolean currentUrl = driver.getCurrentUrl().contains("Web");
		Assert.assertFalse(currentUrl);
		log.error("Wrong course is searched");
	}
	
	
	@Test(priority=6)
	public void negativeFilterCheckForLevel()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectIntermediate();
		boolean currentUrl = driver.getCurrentUrl().contains("beginner");
		Assert.assertFalse(currentUrl);
		log.error("filter for level selected is wrong");
	}
	
	
	@Test(priority=7)
	public void negativeFilterCheckForLanguage2()
	{
		obj2=new UdemyPagesFunctionality(driver);
		obj2.selectWrongLanguage();
		boolean currentUrl = driver.getCurrentUrl().contains("lang=en");
		Assert.assertFalse(currentUrl);
	    log.error("filter for language selected is wrong");
	}
	
	@Test(priority=8)
	public void blankTextbox()
	{
		obj1=new SearchWebDevelopement(driver);
		obj1.SearchWithoutText();
		boolean currentUrl = driver.getCurrentUrl().contains("Web");
		Assert.assertFalse(currentUrl);
		log.info("Enter something on text field");
	}
	
	
	@AfterTest
	public void exit()
	{
		driver.quit();
	}
}

