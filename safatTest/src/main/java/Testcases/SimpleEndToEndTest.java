package Testcases;

import org.testng.annotations.Test;

import base.Base;
import functionLibraries.CategoryLibrary;
import functionLibraries.CheckoutLibrary;
import functionLibraries.LoginLibrary;

public class SimpleEndToEndTest extends Base {

	@Test(priority = 1)
	public void LoginTheCustomer() {

		LoginLibrary.login(driver, username, password);

	}

	@Test(priority = 2, dependsOnMethods = "LoginTheCustomer")
	public void AddTheProductForCheckout() {

		CategoryLibrary.selectFirstProductFromTheFirstCategory(driver);
	}

	@Test(priority = 3, dependsOnMethods = "AddTheProductForCheckout")
	public void MovetoCheckoutAndConfirmTheShippingAndBillingAddress() {

		CheckoutLibrary.checkout(driver, buildingNumber, primaryMobileNumber, location);
	}

	@Test(priority = 4, dependsOnMethods = "MovetoCheckoutAndConfirmTheShippingAndBillingAddress")
	public void SelectDeliveryOption() {

		CheckoutLibrary.selectDeliveryOptions(driver);
	}

	@Test(priority = 5, dependsOnMethods = "SelectDeliveryOption")
	public void SelectKNET() {

		CheckoutLibrary.selectKNETPayment(driver);

	}

	@Test(priority = 6, dependsOnMethods = "SelectKNET")
	public void EnterKNETCardDetailsAndSubmit() {

		CheckoutLibrary.moveToKNETAndCompleteThePayment(driver, bank, cardNumber, expiryMonth, expiryYear, pin);
		System.out.println("This is KNET");

	}

	@Test(priority = 7, dependsOnMethods = "EnterKNETCardDetailsAndSubmit")
	public void VerifyTheOrderOnMyAccount() {

		CheckoutLibrary.VerifyTheLatestOrderOnMyAccount(driver);

	}
}
