package utility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class getScreeshot {

	static String destinationFilePath;

	public static String screenShot(WebDriver driver, String screenShotName) {

		try {
			// String time=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String time = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());

			// LocalDateTime time=LocalDateTime.now();
			

			TakesScreenshot sc = (TakesScreenshot) driver;

			File sourceFile = sc.getScreenshotAs(OutputType.FILE);

			destinationFilePath = System.getProperty("user.dir") + "/ScreenShot/" + screenShotName + time + ".png";

			File DestinationFile = new File(destinationFilePath);

			FileUtils.copyFile(sourceFile, DestinationFile);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return destinationFilePath;
	}

	public static String robotScreenShot(WebDriver driver, String screenShotName) throws AWTException, IOException {

		try {
			Robot robot = new Robot();

			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(dimension);
			BufferedImage source = robot.createScreenCapture(rectangle);
			destinationFilePath = "./ScreenShot/" + screenShotName + ".png";
			ImageIO.write(source, "png", new File(destinationFilePath));
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return destinationFilePath;

	}

}
