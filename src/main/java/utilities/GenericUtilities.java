package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class GenericUtilities {
	
	public static void takesScreenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/DWS_"+getName()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  String getName() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	public static void selectDropdownOption(WebElement dropDown, int option) {
		Select sel = new Select (dropDown);
		sel.selectByIndex(option - 1);
	}
	public static void takesScreenShot(WebElement element) {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/DWS_"+getName()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
