package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.amazonHomePage;
import ObjectRepository.amazonProductPage;
import ObjectRepository.animallHomePage;
import ObjectRepository.flipkartHomePage;
import ObjectRepository.flipkartProductPage;
import ObjectRepository.testBase;
import ObjectRepository.tickerTapeHomePage;
import ObjectRepository.tickerTapeSearchIndexPage;



public class randomTestInTestSuit extends testBase{
	
	amazonHomePage homePage;
	amazonProductPage productPage;
	flipkartHomePage homePage1;
	flipkartProductPage productPage1;
	animallHomePage home;
	tickerTapeHomePage tickHomePage;
	tickerTapeSearchIndexPage tickIndexPage;
	
	public randomTestInTestSuit() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driverInitialization();
		homePage = new amazonHomePage();
		productPage = new amazonProductPage();
		homePage1 = new flipkartHomePage();
		productPage1 = new flipkartProductPage();
		
		home = new animallHomePage();
		
		
		
	}
	
	
	@Test
	public void verifyCostPriceOfMobileOnTwoWebsitesTest() 
	{
		openBrowser("https://www.amazon.in.");
		String homePageTitleAmazon = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitleAmazon, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Home page title not matched");
		homePage.enterValueInSearchbox("Apple iPhone 13 (256GB) - (Product) RED");
		homePage.clickSearchButton();
		int price1 = productPage.priceOfProduct();
		openBrowser("https://www.flipkart.com");
		String homePageTitleFlipkart = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitleFlipkart, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Home page title not matched");
		homePage1.closeLoginPopup();
		homePage1.enterValueInSearchbox("APPLE iPhone 13 ((PRODUCT)RED, 256 GB)");
		homePage1.clickSearchButton();
		int price2 = productPage1.priceOfProduct();
		comparePrice(price1,price2);
		
	}
	
	@Test
	public void verifyAnimalSearchFunctionalityOnWebpage() throws InterruptedException
	{
		openBrowser("https://animall.in/");
		String seller = home.verifyAnimalSearchFunctionality();
		System.out.println(seller);
		
	}
	
	@Test
	public void amazonFlow()
	{
		openBrowser("https://www.amazon.in.");
		
	}
	
	@Test
	public void naviIndexWeeklyPrice()
	{
		openBrowser("https://www.tickertape.in/");
		
	}
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
}
