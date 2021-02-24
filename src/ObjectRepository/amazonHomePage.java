package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class amazonHomePage extends testBase{
	WebDriver driver;
	
	
	public amazonHomePage() {
		driver = super.driver;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public void enterValueInSearchbox(String value)
	{
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' and @type='text']")).sendKeys(value);
		
	}
	
	public void clickSearchButton()
	{
		driver.findElement(By.xpath("//input[@value='Go' and @type='submit']")).click();
	}
}
