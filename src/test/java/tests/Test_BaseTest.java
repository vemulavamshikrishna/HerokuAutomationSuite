package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;

public class Test_BaseTest extends BaseTest{
	WebDriver driver;
	
	@Test
	public void test() {
		
		driver = DriverManager.getDriver();
		System.out.println(driver.getTitle());
		
	}

}
