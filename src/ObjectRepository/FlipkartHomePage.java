package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage extends TestBase {
WebDriver driver;
	
	
	public FlipkartHomePage() {
		driver = super.driver;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public void closeLoginPopup()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'')])[2]")));
		driver.findElement(By.xpath("(//button[contains(text(),'')])[2]")).click();
	}
	
	public void enterValueInSearchbox(String value)
	{
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(value);
		
	}
	
	public void clickSearchButton()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
