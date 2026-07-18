package demoWebShop;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.LoginDetails;
import utilities.File_Utility;
import utilities.GenericUtilities;

public class Login {
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.propertiesfile("url"));
		driver.findElement(By.linkText("Log in")).click();
		LoginDetails login = new LoginDetails(driver);
		login.getEmailTF().sendKeys(File_Utility.propertiesfile("email"));
		login.getPasswordTF().sendKeys(File_Utility.propertiesfile("password"));
		login.getLoginButton().click();
		WebElement element = driver.findElement(By.linkText(File_Utility.propertiesfile("email")));
		if (element.isDisplayed()) {
			GenericUtilities.takesScreenshot(driver);
		}
		driver.quit();
	}
}
