package functionLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.LoginPageObjects;
import utility.ExtentReportUtility;

public class LoginLibrary {

	
	public static void login(WebDriver driver, String UName, String Pwd ) {

		try {

			ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Login");

			ExtentReportUtility.extentTest.info("Launched the Home Page");

			PageFactory.initElements(driver, LoginPageObjects.class);

			LoginPageObjects.LoginButtonOnHomePage.click();

			ExtentReportUtility.extentTest.info("clicked the Login/Register link from the Home page");

			LoginPageObjects.username.sendKeys(UName);
			LoginPageObjects.password.sendKeys(Pwd);
			
			ExtentReportUtility.extentTest.info("Entered the Valid Credentials");
			LoginPageObjects.loginButton.click();

			ExtentReportUtility.extentTest.info("Submitted the credentials for login");
			
			Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());

			ExtentReportUtility.extentTest.info("Login Successfull");

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

	}

}
