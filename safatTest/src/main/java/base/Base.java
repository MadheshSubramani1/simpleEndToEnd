package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BrowserOptions;
import utility.ExtentReportUtility;
import utility.ReadConfig;

public class Base {

	public static WebDriver driver;

	ReadConfig config = new ReadConfig();
	String browser = config.getBrowserFromPOM();
	String url = config.getURL();
	public String username = config.getUserNameFromPOM();
	public String password = config.getPasswordFromPOM();
	public String location = config.getLocation();
	public String buildingNumber = config.getBuildingNumber();
	public String primaryMobileNumber = config.getPrimaryMoileNumber();
	public String bank = config.getBank();
	public String cardNumber = config.getCardNumber();
	public String expiryMonth = config.getExpiryMonth();
	public String expiryYear = config.getExpiryYear();
	public String pin = config.getPIN();

	@BeforeSuite()
	public void launchTheBrowser() throws IOException {

		BrowserOptions browserOptions = new BrowserOptions();

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(browserOptions.chrome());
			driver.get(url);

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(browserOptions.firefox());
			driver.get(url);
		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(browserOptions.edge());
			driver.manage().window().maximize();
			driver.get(url);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		ExtentReportUtility.ExtentReportConfiguration();

	}

	@AfterMethod
	public void afterClass(ITestResult result) {

		ExtentReportUtility.extentListener(result, driver);

	}

	@AfterSuite
	public void tearDown() {

		ExtentReportUtility.extent.flush();
		if (browser != null) {
			 driver.quit();
		}

	}

	public static WebDriver getDriver() {

		return driver;

	}

	public static String getBrowserName() {

		return ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
	}

	public static String getBrowserVersion() {

		return ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();
	}

}
