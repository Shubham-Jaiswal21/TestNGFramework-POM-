package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tickerTapeSearchIndexPage extends testBase {

WebDriver driver;
	
	public tickerTapeSearchIndexPage() {
		driver = super.driver;
	}
	
	
	
	public void verifyIndexPageAndClickOnDateInterval(String interval)
	{
		waitElementUntilDisplayed(driver, By.xpath("(//h1[contains(text(),'Nifty 50 Index')])[1]"));	
		driver.findElement(By.xpath("//span[contains(text(),'"+interval+"')]//parent::div/input[1]")).click();
		waitElementUntilDisplayed(driver, By.xpath("//div[contains(text(),'High')]//following::div[1]"));
		String highValue = driver.findElement(By.xpath("//div[contains(text(),'High')]//following::div[1]")).getText();
		String lowValue = driver.findElement(By.xpath("//div[contains(text(),'Low')]//following::div[1]")).getText();
		System.out.println(interval +" high is :" +highValue);
		System.out.println(interval +" low is :" +lowValue);
		
	}
	
	public void closeSidePopUp()
	{
		driver.findElement(By.xpath("//span[contains(@class,'close')]")).click();
	}
}


