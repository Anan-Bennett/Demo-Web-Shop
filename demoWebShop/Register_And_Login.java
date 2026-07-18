package demoWebShop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.File_Utility;
import utilities.GenericUtilities;

public class Register_And_Login {
	@Test
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.propertiesfile("url"));
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("FirstName")).sendKeys(File_Utility.propertiesfile("firstName"));
		driver.findElement(By.id("LastName")).sendKeys(File_Utility.propertiesfile("lastName"));
		driver.findElement(By.id("Email")).sendKeys(File_Utility.propertiesfile("email"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.propertiesfile("password"));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(File_Utility.propertiesfile("password"));
		driver.findElement(By.id("register-button")).click();
		WebElement element = driver.findElement(By.xpath("//a[text()='mugiwara200513@gmail.com']"));
		if (element.isDisplayed()) {
			GenericUtilities.takesScreenshot(driver);
		}
		driver.quit();


	}
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.propertiesfile("url"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(File_Utility.propertiesfile("email"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.propertiesfile("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		WebElement element = driver.findElement(By.xpath("//a[text()='mugiwara200513@gmail.com']"));
		if (element.isDisplayed()) {
			GenericUtilities.takesScreenshot(driver);
		}
//		driver.quit();
	}
}
