package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class commonUtils {
    static WebDriver driver;

    public commonUtils(WebDriver driver) {
        commonUtils.driver = driver;
    }

    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToFrame(int frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public WebElement waitElementUntilDisplayed(WebElement element, int timer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementUntilClickable(WebElement element, int timer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public boolean isElementPresent(WebElement element, int timer) {
        try {
            waitElementUntilDisplayed(element, timer);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public void scrollDownScreen() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,500)", "");
    }


    public void scrollUpScreen() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,-500)", "");
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void clickAlertOKIfPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException Ex) {
            System.out.println("No Alert Present to click");
        }
    }

    public static int randomNumberGenerator(int n) {
        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(n);
        return randomNumber;
    }

    public static void comparePrice(int price1, int price2) {
        if (price1 > price2)
            System.out.println("Price on Amazon is more than flipkart. Actual Price on Amazon is : " + price1);
        else if (price1 == price2)
            System.out.println("Price on Both Amazon and Flipkart are Same. The Actual price is : " + price1);
        else
            System.out.println("Price on Flipkart is more than Amazon. Actual Price on Flipkart is : " + price2);
    }
}
