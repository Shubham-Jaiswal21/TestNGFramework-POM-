package ObjectRepository;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	//================Switch to Frames via String/Integer/default======>
	public void switchToframe(WebDriver driver,String frame){
		driver.switchTo().frame(frame);
	}
	public void switchToframe(WebDriver driver, int  frame){
		driver.switchTo().frame(frame);
	}
	public void switchToDefault(WebDriver driver){
		driver.switchTo().defaultContent();
	}

	public void clickWebElement(WebDriver driver , By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void sendKeys(WebDriver driver , By locator, String keys)
	{
		driver.findElement(locator).sendKeys(keys);
	}

	public void waitElementUntilDisplayed(WebDriver driver ,By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitElementUntilDisplayed(WebDriver driver ,By locator, int timer){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,timer);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitElementUntilClickable(WebDriver driver ,By locator){//===Wait for element until displayed==>
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void implicitWait(WebDriver driver , int time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS) ;
	}
	
	public  boolean isElementPresent(WebDriver driver ,By locator,int timmer){
		try {
			waitElementUntilDisplayed(driver, locator,timmer);
			return true;
		}catch(Exception e) {
			//System.out.println(locator + " Not found");
			System.out.println(e);
			return false;
		}

	}
	
	public void scrollDownScreen(WebDriver driver){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)", "");
	}


	public void scrollUpScreen(WebDriver driver){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-500)", "");
	}

	public void ScrollToElementLocation(WebDriver driver,By locator){	
		String location =driver.findElement(locator).getLocation().toString();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo"+location+"", "");
	}
	public void clickAlertOKIfPresent(WebDriver driver){
		try
		{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
		catch (NoAlertPresentException Ex) 
	    { 
	        System.out.println("No Alert Present to click");
	    }
	}
	
	public int randomNumberGenerator(int n)
	{
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(n);
		return randomNumber;
	}
}
