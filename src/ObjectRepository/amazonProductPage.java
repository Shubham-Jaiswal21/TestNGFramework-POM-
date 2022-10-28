package ObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazonProductPage extends testBase {
	
WebDriver driver;
	
	
	public amazonProductPage() {
		driver = super.driver;
	}
	
	public int priceOfProduct() 
	{
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apple iPhone XR 256GB Yellow')]//following::a[3]/span[1]/span[1]")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String value = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 13 (256GB) - (Product) RED')]//following::a[3]/span[1]/span[2]/span[2]")).getText();
	//	System.out.println(value);
		String[] parts = value.split(",");
		String price = String.join("", parts);
		int originalPrice= Integer.parseInt(price);
		System.out.println("Amazon Value : "+price);
		return originalPrice;
	}

}
