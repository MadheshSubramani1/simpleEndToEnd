package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Base;
import config.Platform;

public class ExtentReportUtility {

	public static ExtentReports extent;
	public static ExtentSparkReporter extentSpark;
	public static ExtentTest extentTest;
	

	public static void ExtentReportConfiguration() {
		
		String time = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());

		extentSpark = new ExtentSparkReporter("./Report/SparkReport"+time+".html");
		extentSpark.config().setDocumentTitle("X-Cite Automation Report");
		extentSpark.config().setReportName("Functional Test Report");
		extentSpark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(extentSpark);

		extent.setSystemInfo("Tester Name", "Madhesh Subramani");
		extent.setSystemInfo("Username", Platform.USER);
		extent.setSystemInfo("OS", Platform.OS);
		extent.setSystemInfo("OS Version", Platform.OS_VERSION);
		extent.setSystemInfo("OS Arch", Platform.OS_ARCH);
		extent.setSystemInfo("Java Version", Platform.JAVA_VERSION);
		extent.setSystemInfo("WebDriver Version", Platform.WEB_DRIVER_VERSION);
		extent.setSystemInfo("WebDriver Revision", Platform.WEB_DRIVER_REVISION);
		extent.setSystemInfo("Browser Name", Base.getBrowserName());
		extent.setSystemInfo("Browser Version", Base.getBrowserVersion());
		
	}

	public static void extentListener(ITestResult result, WebDriver driver) {

		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(Status.FAIL, result.getName() + " Testcase is Failed ");
			extentTest.log(Status.FAIL, result.getThrowable().getMessage() + " Testcase is Failed ");
			String screenShotpath=utility.getScreeshot.screenShot(driver, result.getName());
			extentTest.log(Status.FAIL, (Markup) extentTest.addScreenCaptureFromPath(screenShotpath));
		}
		if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(Status.PASS,result.getName()+" Testcase is Passed" );
		}
		
		if(result.getStatus()==ITestResult.SKIP) {
			
			extentTest.log(Status.SKIP, result.getName()+" Testcase is Skipped");
		}
	}

}
