package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	WebDriver driver;

	// First product
	@FindBy(xpath = "(//a[@class='hrefch'])[1]") 
	WebElement firstProduct;
	
	// Second product
	@FindBy(xpath = "(//a[@class='hrefch'])[2]") 
	WebElement secondProduct;

	public Productpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectFirstProduct() {
		firstProduct.click();
	}

	public void selectSecondProduct() {
		secondProduct.click();
	}
}
