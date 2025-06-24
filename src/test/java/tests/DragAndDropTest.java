package tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import pages.DragAndDropPage;
import pages.HomePage;

public class DragAndDropTest extends BaseTest {
	
	WebDriver driver;
	
	@Test
	void dragNDropTest() {
		driver = DriverManager.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickDragAndDropLink();
		DragAndDropPage dp = new DragAndDropPage(driver);
		Point a = dp.getPositionOfA();
		Point b = dp.getPositionOfB();
		dp.moveAToB(driver);
		//dp.getReassignedWebElementA();
		//dp.getReassignedWebElementB();
		Assert.assertEquals(dp.getPositionOfB(), a);
		Assert.assertEquals(dp.getPositionOfA(), b);
	}

}
