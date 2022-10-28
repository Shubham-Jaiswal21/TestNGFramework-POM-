package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class tickerTapeHomePage extends testBase{
	WebDriver driver;
	
	public tickerTapeHomePage() {
		driver = super.driver;
	}
	
	public void enterIndexInSearchBar(String value)
	{
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(value);
	}
	
	public void clickOnSearchItem(String value)
	{
		waitElementUntilDisplayed(driver,By.xpath("//span[contains(text(),'"+value+"')]"));
		driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]")).click();
	}

}
