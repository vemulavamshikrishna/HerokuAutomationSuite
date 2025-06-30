package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.BrowserUtils;

public class BaseTest {

	WebDriver driver;
	//public static BaseTest bt;
	/*private BaseTest() {
	}*/

	@Parameters({"browser","url"})
	@BeforeMethod
	public void setUp(@Optional("Chrome")String browserName, String url) {

		switch(browserName) {
		case("Chrome"):
			System.setProperty("webdriver.chrome.driver","./BrowserWebDrivers/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.get(url);
		    break;
		case("Edge"):
			System.setProperty("webdriver.edge.driver","./BrowserWebDrivers/msedgedriver.exe");
		    driver = new EdgeDriver();
		    driver.get(url);
		    break;
		default:
			System.setProperty("webdriver.chrome.driver","./BrowserWebDrivers/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.get(url);
		    break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.setDriver(driver);

	}

	/*public static BaseTest getInstance(){
		if(bt == null ) {
			bt = new BaseTest();
		}
		return bt;
	}*/

	public WebDriver getDriver() {
		return driver;
	}

	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static boolean fluentWaitForVisibilityOfElement(WebElement element, WebDriver driver, int timeout, int pollingInterval) {
		return BrowserUtils.fluentWaitForVisibilityOfElement(element, driver, timeout, pollingInterval);
	}

	public static WebElement reassignWebElementValue(WebElement element) {
		//return driver.findElement(by);
		return element;
	}

	@AfterMethod
	public void tearDown() {

		DriverManager.quitDriver();

	}

}
