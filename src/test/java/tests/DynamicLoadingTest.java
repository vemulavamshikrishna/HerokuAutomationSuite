package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import pages.DynamicLoadingPage;
import pages.DynamicLoadingPage.OnPageElementPage;
import pages.HomePage;

public class DynamicLoadingTest extends BaseTest {
	WebDriver driver;
	
	@Test
	public void testDynamicTest() {
		driver = DriverManager.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickDynamicLoadingLink();
		DynamicLoadingPage dp = new DynamicLoadingPage(driver);
		dp.clickOnPageElementLink();
		OnPageElementPage op = dp.new OnPageElementPage(driver);
		op.clickStartButton();
		assertTrue(op.isOnPageElementVisibleWait(driver));
		String message = op.getLoadedMessage();
		assertEquals(message,"Hello World!");
		System.out.println(message);
	}

}
