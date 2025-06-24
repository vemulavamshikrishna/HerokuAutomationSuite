package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;

public class BrokenImagePage {
	
	@FindBy(xpath = "//h3[text()='Broken Images']")
	WebElement pageHeader;
	
	@FindBy(xpath = "//img[@src='asdf.jpg']")
	WebElement brokenImage1;
	
	@FindBy(xpath = "//img[@src='hjkl.jpg']")
	WebElement brokenImage2;
	
	@FindBy(xpath = "//img[@src='img/avatar-blank.jpg']")
	WebElement normalImage;
	
	@FindBy(xpath = "//h1[text()='Not Found']")
	WebElement notFoundText;
	
	@FindBy(tagName = "img")
	WebElement newTabNormalImgSrc;
	
	public String getSrcValueOfBrokenImage1() {
		return brokenImage1.getAttribute("src");
	}
	
	public String getSrcValueOfBrokenImage2() {
		return brokenImage2.getAttribute("src");
	}
	
	public String getSrcValueOfNormalImage() {
		return normalImage.getAttribute("src");
	}
	
	public String getPageHeaderValue() {
		return pageHeader.getText();
	}
	
	public void rightClickAndSelectBrokenImage(WebDriver driver, String elementName) {
		switch(elementName) {
		case("firstElement"):
			((JavascriptExecutor)driver).executeScript("window.open(arguments[0],'_blank');",getSrcValueOfBrokenImage1());
		    //((JavaScriptExecutor)driver).executeScript("arguments[0].scollIntoView(true);",footer);
		    //((JavaScriptExecutor)driver).executeScript("window.scollTo(0.document.body.scrollHeight"););
		    break;
		case("secondElement"):
			((JavascriptExecutor)driver).executeScript("window.open(arguments[0],'_blank');",getSrcValueOfBrokenImage2());
		    break;
		default:
			throw new IllegalArgumentException("Invalid element name: "+elementName);
		}
	}
	
	public void rightClickAndSelectNormalImage(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("window.open(arguments[0],'_blank');",getSrcValueOfNormalImage());
	}
	
	public String getNotFoundText() {
		return notFoundText.getText();
	}
	
	public String getSrcImageOnNewTab() {
		return newTabNormalImgSrc.getText();
	}
	
	public int getStatusCodeOfBrokenImage1() {
		try {
			System.out.println(getSrcValueOfBrokenImage2());
			return BrowserUtils.checkStatusCode(getSrcValueOfBrokenImage1());
		} catch (Exception e) {
			e.printStackTrace();
			return 404;
		}
	}
	
	public int getStatusCodeOfBrokenImage2() {
		try {
			System.out.println(getSrcValueOfBrokenImage2());
			return BrowserUtils.checkStatusCode(getSrcValueOfBrokenImage2());
		} catch (Exception e) {
			e.printStackTrace();
			return 404;
		}
	}
	
	public int getStatusCodeOfNormalImage() {
		try {
			System.out.println(getSrcValueOfNormalImage());
			return BrowserUtils.checkStatusCode(getSrcValueOfNormalImage());
		} catch (Exception e) {
			e.printStackTrace();
			return 404;
		}
	}
	
	public int getStatusCode(String image) {
		switch(image) {
		case("firstImage"):
			return getStatusCodeOfBrokenImage1();
		case("secondImage"):
			return getStatusCodeOfBrokenImage2();
		case("thirdImage"):
			return getStatusCodeOfNormalImage();
		default:
			throw new IllegalArgumentException("Imvalid image name: "+image);
		}
	}
	
	public BrokenImagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
