package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageObjects {
	
	
	@FindBy(xpath="//div[@class='ms-checkout__google-maps-msg']/following::input[@id='searchTextField']")
	public static WebElement locationTextBOX;
	
	@FindBy(xpath ="(//a[text()='Confirm Location'])[1]")
	public static WebElement confirmLocationButton;

	@FindBy(xpath = "//*[@name='billing[building]']")
	public static WebElement buildingNumber;
	
	
	@FindBy(xpath = "//*[@name='billing[telephone]']")
	public static WebElement primaryMobileNumber;
	
	
	@FindBy(xpath = "//*[@title='Continue']")
	public static WebElement continueButton;
	
	/*
	 * @FindBy(xpath =
	 * "//label[contains(text(),'Select a billing address from your')]") public
	 * static WebElement existingAddress;
	 * 
	 * 
	 * @FindBy(xpath =
	 * "(//div[contains(text(),'Let us know your exact location on Googl')])[1]")
	 * public static WebElement addNewAddres;
	 */
	
	
	
}
