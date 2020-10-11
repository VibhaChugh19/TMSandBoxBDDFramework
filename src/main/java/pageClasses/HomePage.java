package pageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@id='SearchType']")
	WebElement inAllCategoriesDropDown;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement searchButton;
	
	@FindBy(xpath="(//a[text()='Used cars'])[1]")
	WebElement usedCarsLink;
	
	@FindBy(xpath="//a[text()='Kia']")
	WebElement KiaLink;
	
	@FindBy(xpath="//h2[@class='featured-title']")
	WebElement listingSection;
	
	@FindBy(xpath="//a[text()='more...']")
	WebElement moreLink;
	
	@FindBy(xpath="//span[text()=' Christchurch City - Canterbury']")
	WebElement recentCarListingLink;
	
	
	@FindBys(@FindBy(xpath="//span[@class='motors-attribute-value']"))
	List<WebElement> carKeyDetails;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInAllCategories() {
	 
		inAllCategoriesDropDown.click();
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void clickUsedCarsLink() {
		usedCarsLink.click();
	}
	
	public boolean verifykiaLink() {
		return KiaLink.isDisplayed();
	}
	
	public boolean carListingSection() {
		return listingSection.isDisplayed();
	}
	
	public void clickMoreLink() {
		moreLink.click();
	}
	
	public void recentcarListingLink() {
		recentCarListingLink.click();
	}
	
	public ArrayList<String> verifyCarKeydetails() {
		ArrayList<String> carkeyDetails = new ArrayList<String>();
		for(WebElement element:carKeyDetails) {
			String carDetails = element.getText();
			carkeyDetails.add(carDetails);
		}return carkeyDetails;
		
		
	}

}
