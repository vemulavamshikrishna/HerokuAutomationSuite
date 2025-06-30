package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {

	String adTitleXpath = "//div[@class='modal-title']";
	@FindBy(xpath = "//div[@class='modal-title']")
	@CacheLookup
	WebElement adTitle;

	@FindBy(xpath = "//p[text()='Close']")
	@CacheLookup
	WebElement closeAdButton;

	@FindBy(linkText = "click here")
	@CacheLookup
	WebElement clickHereLinkButton;

	@FindBy(xpath = "//div[@class='example']/h3")
	@CacheLookup
	WebElement headerText;

	public String getAdTitle() {
		try{
			return adTitle.getText();
		}catch(Exception e) {
			System.out.println(e);
			return "The elememt is not visible";
		}
	}

	public void waitForEntryAd(WebDriver driver) {
		WebElement adTitle = driver.findElement(By.xpath("//div[@class='modal-title']"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(adTitle));
	}

	public void clickCloseAdButton() {
		closeAdButton.click();
	}

	public void clickClickHereLinkButton() {
		clickHereLinkButton.click();
	}

	public boolean visibilityOfAd(WebDriver driver) {
		WebElement adTitle = driver.findElement(By.xpath(adTitleXpath));
		return adTitle.isDisplayed();
	}

	public boolean invisibilityOfAd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.invisibilityOf(adTitle));
	}

	public String getHeaderText() {
		return headerText.getText();
	}

	public EntryAdPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
