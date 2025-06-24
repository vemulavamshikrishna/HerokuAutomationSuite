package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager; 

public class ExtentReportLogs implements ITestListener {
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ExtentReports extent = ExtentManager.getInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
		test.set(extent.createTest(result.getMethod().getMethodName()));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
