package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	
	
	@FindBy(xpath="(//a[contains (@href,'customer/account/login')])[1]")
	public static WebElement LoginButtonOnHomePage;
	
	
	@FindBy(name="login[username]")
    public static WebElement username;
	
	
	@FindBy(name="login[password]")
    public static WebElement password;
	
	
	@FindBy(xpath="//*[@id='send2']")
    public static WebElement loginButton;
	
	
	
	
	

}
