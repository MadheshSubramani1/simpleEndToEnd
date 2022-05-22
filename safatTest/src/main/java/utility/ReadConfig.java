package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public Properties properties;

	public ReadConfig() {

		File src = new File("config.properties");

		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getBrowser() {
		String browser = properties.getProperty("Browser");
		return browser;
	}

	public String getURL() {
		String url = properties.getProperty("Url");
		return url;
	}

	public String getUserName() {

		String userName = properties.getProperty("UserName");
		return userName;
	}

	public String getPassword() {
		String password = properties.getProperty("Password");
		return password;
	}

	public String getBuildingNumber() {

		String buildingNumber = properties.getProperty("BuildingNumber");

		return buildingNumber;
	}

	public String getPrimaryMoileNumber() {

		String primaryMobileNumber = properties.getProperty("PrimaryMobileNumber");
		return primaryMobileNumber;
	}

	public String getLocation() {

		String location = properties.getProperty("Location");
		return location;
	}

	public String getBank() {

		String bank = properties.getProperty("Bank");
		return bank;
	}

	public String getCardNumber() {

		String cardNumber = properties.getProperty("CardNumber");
		return cardNumber;
	}

	public String getExpiryMonth() {

		String expiryMonth = properties.getProperty("ExpiryMonth");
		return expiryMonth;
	}

	public String getExpiryYear() {

		String expiryYear = properties.getProperty("ExpiryYear");
		return expiryYear;
	}

	public String getPIN() {

		String pin = properties.getProperty("PIN");
		return pin;
	}
	
	public String getBrowserFromPOM() {
		
		String browser=System.getProperty("browserName");
		return browser;
	}
	
	public String getUserNameFromPOM() {
		
		String userName=System.getProperty("userName");
		return userName;
	}
	
	public String getPasswordFromPOM() {
		
		String password=System.getProperty("password");
		return password;
	}
}
