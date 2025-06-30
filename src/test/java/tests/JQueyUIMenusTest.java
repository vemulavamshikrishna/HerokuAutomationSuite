package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import listeners.ExtentReportLogs;
import pages.HomePage;
import pages.JQueryUIMenusPage;

@Listeners(ExtentReportLogs.class)
public class JQueyUIMenusTest extends BaseTest{
	WebDriver driver;
	//BaseTest bt = BaseTest.getInstance();

	@Test
	public void test() {
		//bt.setUp("Chrome", "https://the-internet.herokuapp.com");
		driver = DriverManager.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickJQueryUIMenusLink();
		JQueryUIMenusPage jqp = new JQueryUIMenusPage(driver);
		assertTrue(jqp.disabledLinkState());
		jqp.moveToEnabledLink(driver);
		assertTrue(jqp.isDownloadLinkVisible());
	}

}
