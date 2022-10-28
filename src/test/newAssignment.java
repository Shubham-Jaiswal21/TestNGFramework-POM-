package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.testBase;
import ObjectRepository.tickerTapeHomePage;
import ObjectRepository.tickerTapeSearchIndexPage;



public class newAssignment extends testBase {
	
	tickerTapeHomePage tickHomePage;
	tickerTapeSearchIndexPage tickIndexPage;
	public newAssignment() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driverInitialization();
		
		tickHomePage = new tickerTapeHomePage();
		tickIndexPage = new tickerTapeSearchIndexPage();		
	}
	
	@Test
	public void naviIndexWeeklyPrice()
	{
		openBrowser("https://www.tickertape.in/");
		tickIndexPage.closeSidePopUp();
		tickHomePage.enterIndexInSearchBar("Nifty 50 Index");
		tickHomePage.clickOnSearchItem("Nifty 50 Index");
		tickIndexPage.verifyIndexPageAndClickOnDateInterval("1W");
	}
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	

}
