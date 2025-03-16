package web_ui.pageChildClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.commonUtils;

public class flipkartHomePage {
    WebDriver driver;
    commonUtils utils;

    @FindBy(xpath = "//span[@role = 'button']")
    WebElement closeLoginButton;

    @FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public flipkartHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new commonUtils(driver);
    }

    public flipkartHomePage verifyHomePageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title, "Home page title not matched");
        return this;
    }

    public flipkartHomePage closeLoginPopup() {
        utils.waitElementUntilDisplayed(closeLoginButton, 20);
        closeLoginButton.click();
        return this;
    }

    public flipkartHomePage enterValueInSearchbox(String value) {
        utils.waitElementUntilDisplayed(searchBox, 20);
        searchBox.sendKeys(value);
        return this;
    }

    public flipkartProductPage clickSearchButton() {
        submitButton.click();
        return new flipkartProductPage(driver);
    }
}
