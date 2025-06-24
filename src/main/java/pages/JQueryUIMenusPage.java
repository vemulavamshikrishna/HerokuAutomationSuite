package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JQueryUIMenusPage {
	
    Actions actions;
	
	@FindBy(linkText = "Disabled")
	@CacheLookup
	WebElement disabledLink;
	
	@FindBy(linkText = "Enabled")
	@CacheLookup
	WebElement enabledLink;
	
	@FindBy(linkText = "Downloads")
	@CacheLookup
	WebElement downloadLink;
	
	public JQueryUIMenusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean disabledLinkState() {
		return disabledLink.isEnabled();
	}
	
	public void moveToEnabledLink(WebDriver driver) {
		actions = new Actions(driver);
		actions.moveToElement(enabledLink).build().perform();
	}
	
	public boolean isDownloadLinkVisible() {
		return downloadLink.isDisplayed();
	}

}
