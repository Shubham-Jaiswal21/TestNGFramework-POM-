package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static void driverInitialization()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	public static void openBrowser(String browser)
	{
		driver.get(browser);
		driver.manage().window().maximize();
	}
	
	public void comparePrice(int price1, int price2)
	{
		if(price1>price2)
			System.out.println("Price on Amazon is more than flipkart. Actual Price on Amazon is : "+price1);
		else if(price1 == price2)
			System.out.println("Price on Both Amazon and Flipkart are Same. The Actual price is : "+price1);
		else
			System.out.println("Price on Flipkart is more than Amazon. Actual Price on Flipkart is : "+price2);
	}
}
