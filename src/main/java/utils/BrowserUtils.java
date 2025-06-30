package utils;

import java.lang.reflect.AccessibleObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	public static boolean isPageReady(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.readyState").equals("complete");
	}

	public static void explicitWaitForVisibilityOfElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static Boolean explicitWait(Function<WebDriver , Boolean> condition, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(condition);
	}

	public static Boolean fluentWaitForVisibilityOfElement(final WebElement element, WebDriver driver, int timeout, int pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingInterval))
				.ignoring(NoSuchElementException.class);
		//wait.until(ExpectedConditions.visibilityOf(element));
		return wait.until(new Function<WebDriver,Boolean>(){
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return element.isDisplayed();
				}catch(NoSuchElementException e) {
					return false;
				}
			}
		});
	}

	public static Boolean fluentWait(Function<WebDriver , Boolean> condition, WebDriver driver, int timeout, int pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingInterval))
				.ignoring(NoSuchElementException.class);
		return wait.until(condition);
	}

	public static void switchToNextWindow(WebDriver driver) {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(currentWindow!=window) {
				driver.switchTo().window(window);
			}
		}
	}

	public static void switchToCurrentWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static int checkStatusCode(String url) throws Exception {
		disableSSLCertificateChecking();
		URL locUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)locUrl.openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		return connection.getResponseCode();
	}

	public static void disableSSLCertificateChecking() throws Exception {
	    TrustManager[] trustAllCerts = new TrustManager[]{
	        new X509TrustManager() {
	            public X509Certificate[] getAcceptedIssuers() { return null; }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
	        }
	    };
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(null, trustAllCerts, new SecureRandom());
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
	}

}
