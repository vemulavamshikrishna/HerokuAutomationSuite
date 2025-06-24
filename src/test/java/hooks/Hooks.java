package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;
	String browserName = System.getProperty("browser","Edge");
	String url = System.getProperty("url","https://the-internet.herokuapp.com");
	
	@Before
	public void setUp() {
		
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
	
	@After
    public void tearDown() {
		
		DriverManager.quitDriver();
		
	}

}
