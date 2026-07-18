package demoWebShop;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import credentials.Login;
import utilities.GenericUtilities;
public class BooksModule extends Login{
	@Test
	public void books() throws InterruptedException {

//		Hover and Selecting the books section
		WebElement element = driver.findElement(By.linkText("Books"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		Thread.sleep(1000);
		actions.click(element).perform();
		
//		Checking the dropdowns
		WebElement element2 = driver.findElement(By.id("products-orderby"));
		GenericUtilities.selectDropdownOption(element2, 2);
		WebElement ss = driver.findElement(By.xpath("//div[@class='product-selectors']"));
		Thread.sleep(1000);
		
//		Checking if the input value has been selected in the website
		if (ss.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss);
		}
		
		WebElement element3 = driver.findElement(By.id("products-pagesize"));
		GenericUtilities.selectDropdownOption(element3, 2);
		Thread.sleep(1000);
		
//		Checking if the input value has been selected in the website		
		if (ss.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss);
		}
		
		WebElement element4 = driver.findElement(By.id("products-viewmode"));
		GenericUtilities.selectDropdownOption(element4, 2);
		WebElement ss2 = driver.findElement(By.xpath("//div[@class='product-viewmode']"));
//		Checking if the input value has been selected in the website		
		if (ss2.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss2);
		}
		WebElement element5 = driver.findElement(By.xpath("//a[contains(text(),'Under')]"));
		actions.moveToElement(element5).perform();
		Thread.sleep(1000);
		actions.click(element5).perform();
		WebElement ss3 = driver.findElement(By.xpath("//div[@class='product-list']"));
		if (ss3.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss3);
		}
		
		driver.findElement(By.linkText("Remove Filter")).click();
		driver.findElement(By.linkText("25.00 - 50.00")).click();
		WebElement ss4 = driver.findElement(By.xpath("//div[@class='master-wrapper-content']"));
		if (ss4.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss4);
		}
		driver.findElement(By.linkText("Remove Filter")).click();
		driver.findElement(By.linkText("Over 50.00")).click();
		WebElement ss5 = driver.findElement(By.xpath("//div[@class='product-item']"));
		if (ss5.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss5);
		}
		driver.findElement(By.linkText("Remove Filter")).click();
	}
	@Test
	public void viewProducts() {
		int count = driver.findElements(By.xpath("//h2[@class='product-title']")).size();
		Actions actions = new Actions(driver);
		for (int i = 1; i <= count; i++) {
			driver.findElement(By.xpath("(//h2[@class='product-title'])["+i+"]")).click();
			List<WebElement> quantity = driver.findElements(By.xpath("//input[@class='qty-input']"));
			List<WebElement> addToCart = driver.findElements(By.xpath("//input[@class='button-1 add-to-cart-button']"));
			if (quantity.isEmpty() || addToCart.isEmpty()) {
				driver.navigate().back();
				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[@class='product-title'])["+i+"]")));
				continue;
			}else {
				actions.scrollToElement(quantity.get(0)).perform();
				quantity.get(0).clear();
				quantity.get(0).sendKeys("2");
				addToCart.get(0).click();
				driver.findElement(By.partialLinkText("Shopping cart")).click();
				WebElement ss = driver.findElement(By.xpath("//table[@class='cart']"));
				GenericUtilities.takesScreenShot(ss);
				driver.findElement(By.linkText("BOOKS")).click();
			}
		}
	}
}
