package pageChildClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.commonUtils;

public class amazonHomePage {
    WebDriver driver;
    commonUtils utils;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox' and @type='text']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@value='Go' and @type='submit']")
    private WebElement searchButton;

    public amazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new commonUtils(driver);
    }

    public amazonHomePage verifyHomePageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title, "Home page title not matched");
        return this;
    }

    public amazonHomePage enterValueInSearchbox(String value) {
        utils.waitElementUntilDisplayed(searchBox, 20).clear();
        searchBox.sendKeys(value);
        return this;
    }

    public amazonProductPage clickSearchButton() {
        utils.waitElementUntilClickable(searchButton, 20).click();
        return new amazonProductPage(driver);
    }
}
