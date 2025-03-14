package pageChildClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.commonUtils;

public class amazonProductPage {

    WebDriver driver;
    commonUtils utils;

    public amazonProductPage(WebDriver driver) {
        this.driver = driver;
        utils = new commonUtils(driver);
    }

    public int priceOfProduct() {
        utils.scrollDownScreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String value = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 14 (256 GB) - (Product) RED')]//following::a[3]/span[1]/span[2]/span[2]")).getText();
        String[] parts = value.split(",");
        String price = String.join("", parts);
        int originalPrice = Integer.parseInt(price);
        System.out.println("Amazon Value : " + price);
        return originalPrice;
    }

}
