package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.DriverManager;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrokenImagePage;
import pages.HomePage;
import utils.BrowserUtils;

public class ValidateBrokenImagesSteps {
	WebDriver driver = DriverManager.getDriver();
	BrokenImagePage bp = new BrokenImagePage(driver);
	TestContext testContext;
	String key = "image";

	@Given("user is on broken images page")
	public void user_is_on_broken_images_page() {
		HomePage hp = new HomePage(driver);
		hp.clickBrokenImagesLink();
		Assert.assertEquals(bp.getPageHeaderValue(), "Broken Images");
	}

	@When("user right clicks and opens {string} in a new tab")
	public void user_right_clicks_and_opens_string_in_a_new_tab(String elementName) {
		bp.rightClickAndSelectBrokenImage(driver,elementName);
	}

	@When("user right clicks and opens normal image in a new tab")
	public void user_right_clicks_and_opens_normal_image_in_a_new_tab() {
		bp.rightClickAndSelectNormalImage(driver);
	}

	@When("user opens {string} url")
    public void user_opens_string_url(String image) {
    	int statusCode = bp.getStatusCode(image);
    	testContext = new TestContext();
    	testContext.getScenarioContext().set(key, statusCode);
    }

	@Then("user should get image")
	public void user_should_get_image() {
		Assert.assertEquals(200, testContext.getScenarioContext().get(key));
	}

	@Then("user should see image not found")
	public void user_should_see_image_not_found() {
		BrowserUtils.switchToNextWindow(driver);
		Assert.assertEquals(bp.getNotFoundText(), "Not Found");
	}

	@Then("user should see the image")
	public void user_should_see_the_image() {
		BrowserUtils.switchToNextWindow(driver);
		Assert.assertFalse(bp.getSrcImageOnNewTab().contains("Not Found"));
	}

}
