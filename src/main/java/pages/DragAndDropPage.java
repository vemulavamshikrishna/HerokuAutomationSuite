package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class DragAndDropPage {
	Actions actions;

	@FindBy(xpath = "//header[text()='A']")
	WebElement elementA;

	@FindBy(xpath = "//header[text()='B']")
	WebElement elementB;

	public void moveAToB(WebDriver driver) {
		actions = new Actions(driver);
		actions.dragAndDrop(elementA, elementB).build().perform();
	}

	public Point getPositionOfA() {
		return elementA.getLocation();
	}

	public Point getPositionOfB() {
		return elementB.getLocation();
	}

	public void getReassignedWebElementA() {
		BaseTest.reassignWebElementValue(elementA);
	}

	public void getReassignedWebElementB() {
		BaseTest.reassignWebElementValue(elementB);
	}

	public DragAndDropPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
