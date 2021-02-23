package ObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartProductPage extends TestBase {
WebDriver driver;
	
	
	public FlipkartProductPage() {
		driver = super.driver;
	}
	
	public int priceOfProduct() 
	{
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apple iPhone XR 256GB Yellow')]//following::a[3]/span[1]/span[1]")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String value = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone XR (Yellow, 256 GB) ')]//following::div[contains(text(),'\u20B9')][1]")).getText();
		String value1 = value.substring(1);
		String[] parts = value1.split(",");
		String price = String.join("", parts);
		int originalPrice= Integer.parseInt(price);
		System.out.println(" Flipkart Value : "+price);
		return originalPrice;
	}


}
