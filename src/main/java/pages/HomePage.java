package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Add/Remove Elements")
	@CacheLookup
	WebElement addRemoveLink;

	@FindBy(linkText = "File Upload")
	@CacheLookup
	WebElement fileUploadLink;

	@FindBy(linkText = "JQuery UI Menus")
	@CacheLookup
	WebElement JQueryUIMenusLink;

	@FindBy(linkText = "WYSIWYG Editor")
	@CacheLookup
	WebElement WYSIWYGEditorLink;

	@FindBy(linkText = "Entry Ad")
	@CacheLookup
	WebElement EntryAdLink;

	@FindBy(linkText = "Dynamic Loading")
	@CacheLookup
	WebElement DynamicLoadingLink;

	@FindBy(linkText = "Broken Images")
	@CacheLookup
	WebElement brokenImagesLink;

	@FindBy(linkText = "Drag and Drop")
	@CacheLookup
	WebElement dragAndDropLink;

	public void clickAddRemoveLink() {
		addRemoveLink.click();
	}

	public void clickFileUploadLink() {
		fileUploadLink.click();
	}

	public void clickJQueryUIMenusLink() {
		JQueryUIMenusLink.click();
	}

	public void clickWYSIWYGEditorLink() {
		WYSIWYGEditorLink.click();
	}

	public void clickEntryAdLink() {
		EntryAdLink.click();
	}

	public void clickDynamicLoadingLink() {
		DynamicLoadingLink.click();
	}

	public void clickBrokenImagesLink() {
		brokenImagesLink.click();
	}

	public void clickDragAndDropLink() {
		dragAndDropLink.click();
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
