package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {

	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

			TakesScreenshot scrShot = (TakesScreenshot) driver;//predefined interface, so casting is used to pass the driver.
			File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//format is FILE,temp stored as file

			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date-time format stored

			File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory...saved in folder inside our project.
			//get local path of our project-System.getProperty...OutputScreenShot-folder...stored in f1
			if (!f1.exists()) {

			f1.mkdirs();//repeat line 22 if f1 doesnt exist
			}
			String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
			+ ".png";
			// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
			// ".png";

			File finalDestination = new File(destination);
			FileHandler.copy(screenShot, finalDestination);
			}

}
