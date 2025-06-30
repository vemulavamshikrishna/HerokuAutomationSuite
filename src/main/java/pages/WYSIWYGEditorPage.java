package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WYSIWYGEditorPage {

	@FindBy(tagName = "textarea")
	@CacheLookup
	WebElement textArea;

	public void enterTextinTextarea(String value) {
		try{
			textArea.sendKeys(value);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public String getTextfromTextarea() {
		return textArea.getAttribute("value");
	}

	public WYSIWYGEditorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
