package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ObjectRepository.foodOrderHomepageAndLoginPage;
import ObjectRepository.testBase;

public class testFoodOrder extends testBase {
	
	foodOrderHomepageAndLoginPage orderHomePage;
	String email;
	String password;
	String newPassword;
	
	public testFoodOrder() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driverInitialization();
		orderHomePage = new foodOrderHomepageAndLoginPage();	
		
	}
	
	@Test(priority = 0)
	public void verifyLoginFunctionalityAndCreateAccountAndChangePassword() throws InterruptedException
	{
		openBrowser("https://orderdev.tastemeta.com/home");	
		email = "hello"+randomNumberGenerator(10000)+"@mailinator.com";
		password = "Hello@123";
		newPassword = "Password@123";
		Boolean value = orderHomePage.verifyLoginButton(email,password);
		Assert.assertTrue(value, "The Login details are correct for user");
		orderHomePage.createUserAccount(email , password);
		value = orderHomePage.verifyUserAccountCreation();
		Assert.assertTrue(value, "The User is not Logged out");
		value = orderHomePage.verifyLoginButton(email,password);
		Assert.assertFalse(value, "The Login details are incorrect for user");
		orderHomePage.changePassword(password,newPassword);
		
	}
	
	@Test(priority=1)
	public void checkLoginFunctionalityWithChnagedPassword() throws InterruptedException
	{
		openBrowser("https://orderdev.tastemeta.com/home");
		Boolean value = orderHomePage.verifyLoginButton(email,newPassword);
		Assert.assertFalse(value,"The logins are incorrect for user");
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
