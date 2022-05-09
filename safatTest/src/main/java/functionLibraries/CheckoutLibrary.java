package functionLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.CheckoutPageObjects;
import pageObjects.DeliveryOptionsPageObjects;
import pageObjects.KNETPageObjects;
import pageObjects.MyAccountPageObjects;
import pageObjects.PaymentMethodPageObjects;
import utility.ExtentReportUtility;
import utility.RadionButtonHelper;
import utility.SelectHelper;
import utility.UIWaitHelper;

public class CheckoutLibrary {

	public static void checkout(WebDriver driver, String buildingNum, String primaryMobileNum, String loca) {

		ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Checkout");

		PageFactory.initElements(driver, CheckoutPageObjects.class);

		boolean isAddressExist = false;

		try {
			isAddressExist = driver
					.findElement(By.xpath("//label[contains(text(),'Select a billing address from your')]"))
					.isDisplayed();
		} catch (NoSuchElementException e) {
			isAddressExist = false;

		}
		if (isAddressExist) {

			ExtentReportUtility.extentTest.info("Selected the Existing Shipping and billing Address");

			CheckoutPageObjects.continueButton.click();

			ExtentReportUtility.extentTest.info("Clicked the Continue button");
		}

		else {

			ExtentReportUtility.extentTest
					.info("Billing and Shipping address is does not exist on checkout, so creating the new Address");
			CheckoutPageObjects.locationTextBOX.click();

			CheckoutPageObjects.locationTextBOX.clear();

			CheckoutPageObjects.locationTextBOX.sendKeys(loca);

			try {
				Thread.sleep(2000);
				utility.RobotClass.robotKeysDown();
			} catch (Exception e) {
				e.printStackTrace();
			}

			CheckoutPageObjects.confirmLocationButton.click();

			CheckoutPageObjects.buildingNumber.clear();
			CheckoutPageObjects.buildingNumber.sendKeys(buildingNum);
			CheckoutPageObjects.primaryMobileNumber.clear();
			CheckoutPageObjects.primaryMobileNumber.sendKeys(primaryMobileNum);
			CheckoutPageObjects.continueButton.click();
			ExtentReportUtility.extentTest.info("Clicked the Continue button");
		}
	}

	public static void selectDeliveryOptions(WebDriver driver) {

		PageFactory.initElements(driver, DeliveryOptionsPageObjects.class);
		ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Select Delivery Option");
		RadionButtonHelper.selectRadioButton(driver, DeliveryOptionsPageObjects.FreeDelivery);
		ExtentReportUtility.extentTest.info("Selected the Free Delivery Option");
		DeliveryOptionsPageObjects.continueButton.click();
		ExtentReportUtility.extentTest.info("Clicked the Continue button");
	}

	public static void selectKNETPayment(WebDriver driver) {

		PageFactory.initElements(driver, PaymentMethodPageObjects.class);
		ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Select KNET Payment Method");
		utility.RadionButtonHelper.selectRadioButton(driver, PaymentMethodPageObjects.selectKNET);
		ExtentReportUtility.extentTest.info("Selected the KNET Payment Method");
		UIWaitHelper.waitForAjaxToLoad(driver);
		PaymentMethodPageObjects.continueButton.click();
		ExtentReportUtility.extentTest.info("Clicked the Continue button");

	}

	public static void moveToKNETAndCompleteThePayment(WebDriver driver, String Bnk, String CardNum, String ExpMonth,
			String ExpYear, String pin) {

		PageFactory.initElements(driver, KNETPageObjects.class);
		ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Enter The KNET card details");

		UIWaitHelper.waitForAjaxToLoad(driver);
		
		ExtentReportUtility.extentTest.info("Moved to KNET Page");

		SelectHelper.selectUsingForLoop(KNETPageObjects.selectBank, Bnk);

		UIWaitHelper.waitForAjaxToLoad(driver);

		KNETPageObjects.cardNumberTextBox.sendKeys(CardNum);

		SelectHelper.selectUsingForLoop(KNETPageObjects.expiryMonth, ExpMonth);

		SelectHelper.selectUsingForLoop(KNETPageObjects.expiryYear, ExpYear);

		KNETPageObjects.pin.sendKeys(pin);
		ExtentReportUtility.extentTest.info("Entered the card details");

		KNETPageObjects.submit.click();
		
		ExtentReportUtility.extentTest.info("Submited the card details");

		KNETPageObjects.confirm.click();
		
		ExtentReportUtility.extentTest.info("Confirmed the card details");

	}
	
	public static void VerifyTheLatestOrderOnMyAccount(WebDriver driver) {

		PageFactory.initElements(driver, MyAccountPageObjects.class);

		ExtentReportUtility.extentTest = ExtentReportUtility.extent.createTest("Verify My Account");

		String successpageOrderID = MyAccountPageObjects.getOrderIDFromOrderSuccesspage.getText();
		MyAccountPageObjects.myAccountLink.click();
		
		ExtentReportUtility.extentTest.info("Moved to the My Accounts page");

		String myAccountLatestOrder = MyAccountPageObjects.latestOrderIDFromMyAccount.getText();
		Assert.assertEquals(successpageOrderID, myAccountLatestOrder);

		ExtentReportUtility.extentTest.info("Recently placed order is available on My Acccount");

	}

}
