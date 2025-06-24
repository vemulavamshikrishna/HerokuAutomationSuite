package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import pages.HomePage;
import pages.WYSIWYGEditorPage;

public class WYSIWYGEditorTest extends BaseTest{
	
	WebDriver driver;
	@Test
	public void test() {
		driver = DriverManager.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickWYSIWYGEditorLink();
		WYSIWYGEditorPage wp = new WYSIWYGEditorPage(driver);
		wp.enterTextinTextarea("The new age is coming, everyone has to learn continuosly no matter to what to survive");
		System.out.println(wp.getTextfromTextarea());
	}
	

}
