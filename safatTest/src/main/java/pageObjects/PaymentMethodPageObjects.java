package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethodPageObjects {

	
	
	@FindBy(id="p_method_knet")
	public static WebElement selectKNET;
	
	
	
	@FindBy(xpath="//button[@class='btn-checkout opc-btn-payment xc-btn xc-btn-orange placeorder trackable ms-checkout__next-button']")
	public static WebElement continueButton;
}
