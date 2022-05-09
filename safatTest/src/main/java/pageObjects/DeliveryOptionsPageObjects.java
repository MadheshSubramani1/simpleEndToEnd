package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryOptionsPageObjects {
	
	
	
	@FindBy(xpath= "//input[@id='s_method_freeshipping_freeshipping']")
	public static WebElement FreeDelivery;
	
	
	@FindBy(xpath= "//button[@title='Continue to Payment']")
	public static WebElement continueButton;
	
	
	

}
