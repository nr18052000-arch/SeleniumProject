package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cartButton;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrder;

    public Cartpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCart.click();
    }

    public void goToCart() {
        cartButton.click();
    }

    public void placeOrder() {
        placeOrder.click();
    }
}
