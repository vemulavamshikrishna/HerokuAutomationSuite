package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import listeners.ExtentReportLogs;
import pages.AddRemoveElementsPage;
import pages.HomePage;
import utils.BrowserUtils;

@Listeners(ExtentReportLogs.class)
public class AddRemoveElementsTest extends BaseTest{
	WebDriver driver;
	//BaseTest bt = BaseTest.getInstance();

	@Test//(invocationCount = 2)
	public void test() {
		driver = DriverManager.getDriver();
		System.out.println(driver.getTitle());
		HomePage hp = new HomePage(driver);
		hp.clickAddRemoveLink();
		BrowserUtils.isPageReady(driver);
		AddRemoveElementsPage ap = new AddRemoveElementsPage(driver);
		ap.clickAddElement();
		assertTrue(ap.isNewElementAdded(driver),"The element is added");
		ap.clickRemoveElement();
		try{
			assertFalse(ap.isElementDeleted());
		} catch (StaleElementReferenceException e) {
			System.out.println("The element is deleted");
		}
		navigateBack();
	}

}
