package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBase {

	public static WebDriver driver;
	public static void driverInitialization()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome\\chromedriver.exe");
		//System.out.println(System.getProperty("user.dir"));
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
