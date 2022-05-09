package utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class UIWaitHelper {
	
	int maxTimeoutInSeconds;
	private final static int AJAX_LOAD_TIME_OUT = 120;
	private static final int PAGE_LOAD_TIME_OUT = 100;

	public static void pollAndWaitByXpath(WebDriver driver, final String xpath, int maxTimeoutInSeconds,
			int pollingInSeconds, boolean clickElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(maxTimeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}
		});

		if (clickElement)
			element.click();
	}
	
	
	public static void waitForAjaxToLoad(WebDriver driver) {
		//CombinedLogger.info("Starting wait for AJAX to Load");
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(AJAX_LOAD_TIME_OUT));
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					//CombinedLogger.info("No. of Active AJAX connections      : "	 String.valueOf(((JavascriptExecutor) driver).executeScript("return jQuery.active"));
					return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
				}
			});
		} catch (JavascriptException e) {
			//CombinedLogger.info("ReferenceError: jQuery is not defined");
		}catch (WebDriverException e) {
			//CombinedLogger.info("ReferenceError: jQuery is not defined");
		}	
		//CombinedLogger.info("Finished wait for AJAX to Load");
	}
	
	public static void waitForPageLoad(WebDriver driver) {
		//CombinedLogger.info("Starting wait for PageLoad");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIME_OUT));
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				//CombinedLogger.info("Current Window State       : "	+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
		//CombinedLogger.info("Finshed wait for PageLoad");
	}

}