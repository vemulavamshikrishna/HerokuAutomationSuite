package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.BrowserUtils;

public class DynamicLoadingPage {

	@FindBy(linkText = "Example 1: Element on page that is hidden")
	@CacheLookup
	WebElement onPageElementLink;

	@FindBy(linkText = "Example 2: Element rendered after the fact")
	@CacheLookup
	WebElement notOnPageElementLink;

	public void clickOnPageElementLink() {
		onPageElementLink.click();
	}

	public void clickNotOnPageElementLink() {
		notOnPageElementLink.click();
	}

	public DynamicLoadingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public class OnPageElementPage{

		@FindBy(xpath = "//button[text()='Start']")
		@CacheLookup
		WebElement startButton;

		@FindBy(xpath = "//h4[text()='Hello World!']")
		@CacheLookup
		WebElement loadedMessage;

		public void clickStartButton() {
			startButton.click();
		}

		public String getLoadedMessage() {
			return loadedMessage.getText();
		}

		public boolean isOnPageElementVisible(WebDriver driver) {
			return BaseTest.fluentWaitForVisibilityOfElement(loadedMessage, driver, 20, 2);
		}

		public Boolean isOnPageElementVisibleWait(WebDriver driver) {
			return BrowserUtils.fluentWait(WebDriver -> loadedMessage.isDisplayed(), driver, 20, 2);
		}

		public OnPageElementPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

	}

}
