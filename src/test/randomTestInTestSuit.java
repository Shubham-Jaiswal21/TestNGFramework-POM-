package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageChildClass.amazonHomePage;
import pageChildClass.flipkartHomePage;
import utils.commonUtils;

public class randomTestInTestSuit extends testBase {

    amazonHomePage homePage;
    flipkartHomePage homePage1;
    WebDriver driver;

    public randomTestInTestSuit() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driver = driverInitialization();

    }

    @Test
    public void verifyCostPriceOfMobileOnTwoWebsitesTest() {
        openBrowser("https://www.amazon.in/");
        homePage = new amazonHomePage(driver);
        homePage1 = new flipkartHomePage(driver);
        int price1 = homePage.verifyHomePageTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in").enterValueInSearchbox("Apple iPhone 14 (256GB) - (Product) RED").clickSearchButton().priceOfProduct();
        openBrowser("https://www.flipkart.com");
        int price2 = homePage1.verifyHomePageTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!").enterValueInSearchbox("Apple iPhone 14 red 256 gb").clickSearchButton().priceOfProduct();
        commonUtils.comparePrice(price1, price2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
