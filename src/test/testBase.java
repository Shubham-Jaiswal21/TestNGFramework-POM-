package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBase {

    public static WebDriver driver;

    public static WebDriver driverInitialization() {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome\\chromedriver.exe");
//		System.out.println(System.getProperty("user.dir"));
        driver = new ChromeDriver();
        return driver;
    }

    public static void openBrowser(String website) {
        driver.get(website);
        driver.manage().window().maximize();
    }

}
