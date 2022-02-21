package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class foodOrderHomepageAndLoginPage extends testBase {

WebDriver driver;

public By loginButtonXpath = By.xpath("//p[contains(@class,'login cursor')]");
public By enterEmailBoxXpath = By.xpath("//input[@placeholder='Enter Email Address ']");
public By enterPasswordBoxXpath = By.xpath("//input[@placeholder='Enter Password']");
public By signButtonXpath = By.xpath("//button[@type='submit']");
public By createAccountButtonXpath = By.xpath("//button[contains(text(),'Create an account')]");

public By enterFirstNameBoxXpath = By.xpath("//input[@placeholder='Enter first name']");
public By enterLastNameBoxXpath = By.xpath("//input[@placeholder='Enter last name']");
public By enterPhoneXpath = By.xpath("//input[@formcontrolname='phone']");
public By enterEmailXpath = By.xpath("//input[@placeholder='Enter Email Address']");
public By enterPasswordXpath = By.xpath("//input[@placeholder='Enter Password']");
public By enterNewPasswordXpath = By.xpath("//input[@placeholder='Enter new password']");
public By enterConfirmPasswordXpath = By.xpath("//input[@placeholder='Enter confirm password']");
public By checkboxAgreeToAll = By.xpath("(//span[@class='checkmark'])[1]");

public By createAccountButton = By.xpath("//button[contains(text(),'Create an account')]");
public By logoutButton = By.xpath("//p[contains(text(),'Logout')]");
public By confirmButton = By.xpath("//button[contains(text(),'Confirm')]");

public By settingsButton = By.xpath("//a[contains(text(),'Settings')]");
public By changePasswordButton = By.xpath("//p[contains(text(),'Password')]");
public By closeButton = By.xpath("//button[@class='close']");
	
	public foodOrderHomepageAndLoginPage() {
		driver = super.driver;
		 
	}
	
	public Boolean verifyLoginButton(String email, String password) throws InterruptedException
	{
		waitElementUntilDisplayed(driver,loginButtonXpath);
		waitElementUntilClickable(driver, loginButtonXpath);	
		clickWebElement(driver, loginButtonXpath);
		waitElementUntilDisplayed(driver,enterEmailBoxXpath);
		sendKeys(driver, enterEmailBoxXpath, email);
		sendKeys(driver, enterPasswordBoxXpath, password);
		clickWebElement(driver, signButtonXpath);
		Thread.sleep(2000);
		Boolean value = isElementPresent(driver, enterEmailBoxXpath, 10);
		return value;
		
	}
	
	public void createUserAccount(String email, String password) throws InterruptedException
	{
		
		waitElementUntilClickable(driver, createAccountButtonXpath);	
		clickWebElement(driver, createAccountButtonXpath);
		Thread.sleep(2000);
		sendKeys(driver, enterFirstNameBoxXpath, "Hello");
		sendKeys(driver, enterLastNameBoxXpath, "Singh");
		sendKeys(driver, enterPhoneXpath, "3381234567");
		sendKeys(driver, enterEmailXpath, email);
		sendKeys(driver, enterPasswordXpath,password);
		ScrollToElementLocation(driver, checkboxAgreeToAll);
		clickWebElement(driver, checkboxAgreeToAll);
		Thread.sleep(2000);
		clickWebElement(driver, createAccountButton);
		Thread.sleep(2000);
		
	}
	
	public Boolean verifyUserAccountCreation() throws InterruptedException
	{
		Thread.sleep(3000);
		clickAlertOKIfPresent(driver);
		Thread.sleep(2000);
		clickWebElement(driver, closeButton);
		Boolean value = isElementPresent(driver, logoutButton, 10);
		Boolean value2 = false;
		if(value==true)
		{
			
			Thread.sleep(2000);
			clickWebElement(driver, logoutButton);
			Thread.sleep(2000);
			value2 = isElementPresent(driver, loginButtonXpath, 10);
		}
		else
			Assert.assertTrue(value,"User is not logged in after user creation");
		return value2;
	}
	
	public void changePassword(String actualPassword,String newPassword) throws InterruptedException
	{
		Thread.sleep(2000);
		clickAlertOKIfPresent(driver);
		Thread.sleep(2000);
		clickWebElement(driver, closeButton);
		Thread.sleep(2000);
		waitElementUntilDisplayed(driver,settingsButton);
		waitElementUntilClickable(driver, settingsButton);
		clickWebElement(driver, settingsButton);
		waitElementUntilDisplayed(driver,changePasswordButton);
		clickWebElement(driver, changePasswordButton);
		waitElementUntilDisplayed(driver,enterPasswordXpath);
		waitElementUntilDisplayed(driver,enterNewPasswordXpath);
		waitElementUntilDisplayed(driver,enterConfirmPasswordXpath);
		sendKeys(driver, enterPasswordXpath, actualPassword);
		sendKeys(driver, enterNewPasswordXpath, newPassword);
		sendKeys(driver, enterConfirmPasswordXpath, newPassword);
		Thread.sleep(2000);
		clickWebElement(driver, confirmButton);
		Thread.sleep(5000);
	}

	
}
