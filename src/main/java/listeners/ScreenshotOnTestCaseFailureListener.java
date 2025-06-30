package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenShotUtil;

public class ScreenshotOnTestCaseFailureListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest testClass = (BaseTest)result.getInstance();
		WebDriver driver = testClass.getDriver();
		String methodName = result.getName();
		ScreenShotUtil.triggerScreenShot(driver,methodName);
		System.out.println("Screenshot taken for failes test: "+methodName);
	}

}
