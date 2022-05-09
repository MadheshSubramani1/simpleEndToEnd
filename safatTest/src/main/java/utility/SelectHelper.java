package utility;

import java.util.List;

import org.openqa.selenium.WebElement;


public class SelectHelper {

	public static void selectUsingForLoop(List<WebElement> lists, String BankName) {

		for (WebElement list : lists) {

			if (list.getText().equals(BankName)) {

				list.click();

				break;
			}
		}
	}
}