package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\vemula.krishna\\eclipse-workspace\\ui_automation\\src\\test\\resources\\features\\vaildateBrokenImages.feature"},
		glue = {"stepDefinitions","hooks"},
	    plugin={"html:src\\test\\java\\reports\\rep.html"},
		tags = "@sanity and not @smoke"
		)

/*@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME,value="stepDefinitions,hooks")
@ConfigurationParameter(key = io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME,value="pretty,html:target/cucumber-report.html")*/

public class RunnerClass extends AbstractTestNGCucumberTests
{

}
