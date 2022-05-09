package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KNETPageObjects {

	@FindBy(xpath = "//select[@class='paymentselect bank']/option")
	public static List<WebElement> selectBank;

	@FindBy(id = "debitNumber")
	public static WebElement cardNumberTextBox;

	@FindBy(xpath = "//div[@id='cardExpdate']/div[2]/select[1]/option")
	public static List<WebElement> expiryMonth;

	@FindBy(xpath = "//div[@id='cardExpdate']/div[2]/select[2]/option")
	public static List<WebElement> expiryYear;

	@FindBy(id = "cardPin")
	public static WebElement pin;

	@FindBy(xpath = "//input[@id='proceed']")
	public static WebElement submit;

	@FindBy(id = "proceedConfirm")
	public static WebElement confirm;
}
