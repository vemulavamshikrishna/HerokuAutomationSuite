package utils;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	
	public static String triggerScreenShot(WebDriver driver, String screenshotName) {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String path = "./target/"+screenshotName+".png";
		try{
			File destFile = new File(path);
			Files.createDirectories(destFile.getParentFile().toPath());
			Files.copy(srcFile.toPath(), destFile.toPath());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
		
	}

}
