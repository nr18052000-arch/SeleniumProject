package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpagedemo {
	    WebDriver driver;

	    @FindBy(id = "login2")
	    WebElement loginButton;

	    @FindBy(id = "loginusername")
	    WebElement username;

	    @FindBy(id = "loginpassword")
	    WebElement password;

	    @FindBy(xpath = "//button[text()='Log in']")
	    WebElement submitLogin;

	    public Loginpagedemo(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String user, String pass) {
	        loginButton.click();
	        username.sendKeys(user);
	        password.sendKeys(pass);
	        submitLogin.click();
	    }
	}

