package pageObjects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// THIS CLASS CONATAINS ALL THE FUNCTIONALITY

public class UdemyPagesFunctionality
{
	public WebDriver driver;
	WebElement ele;
	
//	XPATH USED IN THE PROJECT
	
	By level=By.xpath("//*[text()='Beginner' and @class='udlite-toggle-input-container udlite-text-sm']");
	By language=By.xpath("//label[(text()='Language') and @class='js-panel-toggler  panel--label--qoWJs']");
	By englishlanguage =By.xpath("//fieldset[@name='Language']//label[@class='udlite-toggle-input-container udlite-text-sm'][contains(text(),'English')]");
	By title1=By.xpath("//div[contains(text(),'Beginner Full Stack Web Development: HTML, CSS, React & Node') and @class='udlite-heading-sm udlite-focus-visible-target course-card--course-title--2f7tE']");
	By rating1=By.xpath("//div[@class='course-list--container--3zXPS']/div[1]/div[1]/a/div[1]/div[3]/span/span[2]");
	By duration1=By.xpath("//div[@class='course-list--container--3zXPS']/div[1]/div[1]/a/div[1]/div[4]/span[1]");
	By title2=By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/div[1]/a/div[1]/div[1]");
	By rating2=By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/div[1]/a/div[1]/div[3]/span/span[2]");
	By duration2=By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/div[1]/a/div[1]/div[4]/span[1]");
	By lvlintermediate=By.xpath("//*[text()='Intermediate' and @class='udlite-toggle-input-container udlite-text-sm']");
	By wrongLanguage=By.xpath("//fieldset[@name='Language']//label[@class='udlite-toggle-input-container udlite-text-sm'][contains(text(),'Español')]");
	
	public  UdemyPagesFunctionality(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectLevel()
	{
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(level).click();
	}
	
	public void selectIntermediate()
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(lvlintermediate).click();
	}
	
	public void selectLanguage()
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//driver.findElement(language).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(language).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(englishlanguage).click();
		
	}
	
	public void selectWrongLanguage()
	{
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		driver.findElement(language).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		driver.findElement(wrongLanguage).click();
	}
	
	


	
	public void printConsole()
	{
		System.out.println(driver.findElement(title1).getText());
		System.out.println(driver.findElement(rating1).getText());
		System.out.println(driver.findElement(duration1).getText());
		System.out.println(driver.findElement(title2).getText());
		System.out.println(driver.findElement(rating2).getText());
		System.out.println(driver.findElement(duration2).getText());

	}
	
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}