package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portfoliodetails {
	
	public Portfoliodetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "HOME" )
	private WebElement home;
	
	@FindBy(linkText = "About")
	private WebElement about;
	
	@FindBy(linkText = "EXPERIENCE")
	private WebElement experience;
	
	@FindBy(linkText = "GALLERY")
	private WebElement gallery;
	
	@FindBy(linkText = "VIDEOS")
	private WebElement videos;
	
	@FindBy(linkText = "CONTACT")
	private WebElement contact;

	public WebElement getHome() {
		return home;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getExperience() {
		return experience;
	}

	public WebElement getGallery() {
		return gallery;
	}

	public WebElement getVideos() {
		return videos;
	}

	public WebElement getContact() {
		return contact;
	}
}
