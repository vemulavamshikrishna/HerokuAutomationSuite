package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	private ExtentManager() {}

	public static ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./test-output/myReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;
	}

}
