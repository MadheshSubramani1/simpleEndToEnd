package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryAndPrdocutPageObjects {
	
	@FindBy(xpath="(//ul[@Class='nav navbar-nav']/li/a)[1]")
	public static WebElement getFirstCategory;
	
	
	@FindBy(xpath="(//a[contains(@href, 'product/view/id')])[1]")
	public static WebElement getFirstProduct;
	
	
	@FindBy(xpath = "//*[@id='click-desktop']/button[@title='1-Click Buy']")
	public static WebElement one_Click_Buy;
	

}
