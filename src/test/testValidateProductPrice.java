package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.amazonHomePage;
import ObjectRepository.amazonProductPage;
import ObjectRepository.flipkartHomePage;
import ObjectRepository.flipkartProductPage;
import ObjectRepository.testBase;



public class testValidateProductPrice extends testBase{
	
	amazonHomePage homePage;
	amazonProductPage productPage;
	flipkartHomePage homePage1;
	flipkartProductPage productPage1;
	
	public testValidateProductPrice() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driverInitialization();
		homePage = new amazonHomePage();
		productPage = new amazonProductPage();
		homePage1 = new flipkartHomePage();
		productPage1 = new flipkartProductPage();
	}
	
	
	@Test
	public void verifyCostPriceOfMobileOnTwoWebsitesTest() 
	{
		openBrowser("https://www.amazon.in.");
		String homePageTitleAmazon = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitleAmazon, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Home page title not matched");
		homePage.enterValueInSearchbox("Apple iPhone XR 256GB Yellow");
		homePage.clickSearchButton();
		int price1 = productPage.priceOfProduct();
		openBrowser("https://www.flipkart.com");
		String homePageTitleFlipkart = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitleFlipkart, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Home page title not matched");
		homePage1.closeLoginPopup();
		homePage1.enterValueInSearchbox("Apple iPhone XR 256GB Yellow");
		homePage1.clickSearchButton();
		int price2 = productPage1.priceOfProduct();
		comparePrice(price1,price2);
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
