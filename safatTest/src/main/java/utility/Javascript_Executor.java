package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascript_Executor {
	
	
	public static void Flash(WebDriver driver, WebElement element) {

		String backgroundColor = element.getCssValue("backgroundColor");

		for (int i = 0; i < 500; i++) {

			changeColor(driver, element, "#000000");
			changeColor(driver, element, backgroundColor);
		}
	}

	public static void changeColor(WebDriver driver, WebElement element, String color) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		// js.executeScript("arguments[0].style.backgroundColor='#000000';",PasswordField);
		try {
			Thread.sleep(20);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void getborderByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border=' red 7px solid';", element);
	}

	public static String gettitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static void sendkeysByJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}

	public static void clickByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void alertByJS(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "');");
	}

	public static void scrollIntoViewJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollPageDown(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void refresh(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}

	public static void forwardBackward(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.back()");
		js.executeScript("window.history.forward()");

	}

}
