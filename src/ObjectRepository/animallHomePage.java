package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class animallHomePage extends testBase{

WebDriver driver;
public By searchAnimalButtonXpath = By.xpath("//div[@class='btn-filter-lists']");
public By filterTabOfMilkQuantityXpath = By.xpath("//div[@id='filterTab-Milk']/div/span");
public By fifthOptionInMilkQuantityFilterTab = By.xpath("//div[@class='options milk-options']/div[5]");
public By applyFilterButtonXpath = By.xpath("//div[@class='apply-filter']");

	
	
	public animallHomePage() {
		driver = super.driver;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyAnimalSearchFunctionality() throws InterruptedException
	{
		switchToframe(driver, "animallHomeUrl");
		
		waitElementUntilDisplayed(driver,searchAnimalButtonXpath);
		waitElementUntilClickable(driver, searchAnimalButtonXpath);	
		clickWebElement(driver, searchAnimalButtonXpath);
		
		waitElementUntilDisplayed(driver,filterTabOfMilkQuantityXpath);
		waitElementUntilClickable(driver, filterTabOfMilkQuantityXpath);
		clickWebElement(driver, filterTabOfMilkQuantityXpath);
		
	
		waitElementUntilDisplayed(driver,fifthOptionInMilkQuantityFilterTab);
		waitElementUntilClickable(driver, fifthOptionInMilkQuantityFilterTab);
		clickWebElement(driver, fifthOptionInMilkQuantityFilterTab);
		
		
		waitElementUntilDisplayed(driver,applyFilterButtonXpath);
		waitElementUntilClickable(driver, applyFilterButtonXpath);
		clickWebElement(driver, applyFilterButtonXpath);
			
		waitElementUntilDisplayed(driver,searchAnimalButtonXpath);
		Thread.sleep(5000);
		
		String potentialSeller = driver.findElement(By.xpath("(//div[@class='seller-name']/span)[1]")).getText();
		return potentialSeller;
	}
}
