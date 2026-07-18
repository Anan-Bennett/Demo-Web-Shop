package credentials;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.LoginDetails;
import utilities.File_Utility;
public class Login{
	public static WebDriver driver = new ChromeDriver();
	@Test
	public void login() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.propertiesfile("url1"));
		driver.findElement(By.linkText("Log in")).click();
		LoginDetails login = new LoginDetails(driver);
		login.getEmailTF().sendKeys(File_Utility.propertiesfile("email"));
		login.getPasswordTF().sendKeys(File_Utility.propertiesfile("password"));
		login.getLoginButton().click();
	}
}