package functionLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.CategoryAndPrdocutPageObjects;
import utility.ExtentReportUtility;

public class CategoryLibrary {
	
	public static void selectFirstProductFromTheFirstCategory(WebDriver driver) {
		

		try {
			ExtentReportUtility.extentTest = ExtentReportUtility.extent
					.createTest("Select Product From The Categories page");

			PageFactory.initElements(driver, CategoryAndPrdocutPageObjects.class);

			CategoryAndPrdocutPageObjects.getFirstCategory.click();
			
			ExtentReportUtility.extentTest.info("Selected the First Category");

			ExtentReportUtility.extentTest.info("Moved to the PLP page");

			CategoryAndPrdocutPageObjects.getFirstProduct.click();
			
			ExtentReportUtility.extentTest.info("Selected the first product from the PLP");

			ExtentReportUtility.extentTest.info("Moved to the PDP page");

			CategoryAndPrdocutPageObjects.one_Click_Buy.click();

			ExtentReportUtility.extentTest.info("Clicked the \"1-Click Buy button\"");
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

}
