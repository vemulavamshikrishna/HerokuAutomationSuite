package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElementsPage {
	
	@FindBy(xpath = "//button[text()='Add Element']")
	WebElement addElement;
	
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement deleteElement;
	
	public void clickAddElement() {
		addElement.click();
	}
	
    public void clickRemoveElement() {
    	deleteElement.click();
    }
    
    public boolean isNewElementAdded(WebDriver driver) {
    	try {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        return
        wait.until(ExpectedConditions.invisibilityOf(addElement));
    	} catch(NoSuchElementException ne) {
    		return true;
    	}
    }
    
    public boolean isElementDeleted() {
    	
    	if(!deleteElement.isDisplayed()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public AddRemoveElementsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
