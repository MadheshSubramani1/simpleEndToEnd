package config;

import org.openqa.selenium.WebDriver;

public interface Browser {

	
	public WebDriver getDriver();
	
	public String getBrowserName();
	
	public String getBrowserVersion();
}
