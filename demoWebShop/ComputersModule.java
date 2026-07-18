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

public class ComputersModule extends Login{
	@Test
	public void Computers() throws InterruptedException {
		WebElement element = driver.findElement(By.linkText("COMPUTERS"));
		WebElement element2 = driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		Thread.sleep(1000);
		actions.moveToElement(element2).perform();
		actions.click().perform();
		WebElement order = driver.findElement(By.id("products-orderby"));
		GenericUtilities.selectDropdownOption(order, 4);
		WebElement ss = driver.findElement(By.xpath("//div[@class='product-selectors']"));
		if (ss.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss);
		}
		WebElement viewMode = driver.findElement(By.id("products-viewmode"));
		GenericUtilities.selectDropdownOption(viewMode, 2);
		WebElement ss2 = driver.findElement(By.xpath("//div[@class='product-selectors']"));
		if (ss2.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss2);
		}
		WebElement pageSize = driver.findElement(By.id("products-pagesize"));
		GenericUtilities.selectDropdownOption(pageSize, 2);
		WebElement ss3 = driver.findElement(By.xpath("//div[@class='product-selectors']"));
		if (ss3.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss3);
		}
		driver.findElement(By.linkText("Under 1000.00")).click();
		WebElement ss4 = driver.findElement(By.xpath("//div[@class='page-body']"));
		if (ss4.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss4);
		}
		driver.findElement(By.linkText("Remove Filter")).click();
		driver.findElement(By.linkText("1000.00 - 1200.00")).click();
		WebElement ss5 = driver.findElement(By.xpath("//div[@class='page-body']"));
		if (ss5.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss5);
		}
		driver.findElement(By.linkText("Remove Filter")).click();
		driver.findElement(By.linkText("Over 1200.00")).click();
		WebElement ss6 = driver.findElement(By.xpath("//div[@class='page-body']"));
		if (ss6.isDisplayed()) {
			GenericUtilities.takesScreenShot(ss6);
		}
		driver.findElement(By.linkText("Remove Filter")).click();
	}
	
	@Test
	public void viewProducts() throws InterruptedException {
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
				WebElement element = driver.findElement(By.linkText("COMPUTERS"));
				WebElement element2 = driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));
				actions.moveToElement(element).perform();
				Thread.sleep(1000);
				actions.moveToElement(element2).perform();
				actions.click().perform();
			}
		}
		driver.quit();
	}
}
