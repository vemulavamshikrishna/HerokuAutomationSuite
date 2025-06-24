package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import listeners.RerunningTheFailedTestCase;
import listeners.ScreenshotOnTestCaseFailureListener;
import pages.EntryAdPage;
import pages.HomePage;

@Listeners(ScreenshotOnTestCaseFailureListener.class)
public class EntryAdTest extends BaseTest {
	WebDriver driver;
	
	@Test(retryAnalyzer = listeners.RerunningTheFailedTestCase.class)
	public void testEntryAd() {
		driver = DriverManager.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickEntryAdLink();
		EntryAdPage ep = new EntryAdPage(driver);
		assertEquals(ep.getAdTitle().toLowerCase(), "This is a modal window".toLowerCase());
		ep.clickCloseAdButton();
		assertEquals(ep.getHeaderText(),"Entry Ad");
		navigateRefresh();
		assertFalse(ep.visibilityOfAd(driver));
		ep.clickClickHereLinkButton();
		navigateRefresh();
		ep.waitForEntryAd(driver);
		assertTrue(ep.visibilityOfAd(driver));
	}

}
