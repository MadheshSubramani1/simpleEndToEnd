package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObjects {

	
	
	@FindBy(xpath = "//p[text()='Your order # is: ']/a")
	public static WebElement getOrderIDFromOrderSuccesspage;
	
	@FindBy(linkText = "Account")
	public static WebElement myAccountLink;
	
	
			
	@FindBy(xpath ="(//table[@id='my-orders-table']/tbody/tr/td[1])[1]")		
    public static WebElement latestOrderIDFromMyAccount;
	
}
