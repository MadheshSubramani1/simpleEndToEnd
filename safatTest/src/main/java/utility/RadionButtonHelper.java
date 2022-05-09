package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadionButtonHelper {

	public static void selectRadioButton(WebDriver driver, WebElement element) {

		boolean isSelected = element.isSelected();

		if (isSelected == false);
		{

			element.click();
		}

	}

}
