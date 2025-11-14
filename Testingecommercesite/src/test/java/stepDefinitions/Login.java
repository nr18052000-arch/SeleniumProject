package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	    WebDriver driver;

	    @Given("user is on Demoblaze login page")
	    public void user_is_on_demoblaze_login_page() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.demoblaze.com/");
	        driver.findElement(By.id("login2")).click(); // Click login button to open modal
	    }

	    @When("user logs in with valid credentials")
	    public void user_logs_in_with_valid_credentials() throws InterruptedException {
	        Thread.sleep(1000); // Wait for modal
	        driver.findElement(By.id("loginusername")).sendKeys("Nirmalraju19090");
	        driver.findElement(By.id("loginpassword")).sendKeys("nirmalraju19090");
	        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	        Thread.sleep(3000); // Wait for login to complete
	    }

	    @When("adds two products to cart")
	    public void adds_two_products_to_cart() throws InterruptedException {
	        driver.findElement(By.linkText("Samsung galaxy s6")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.linkText("Add to cart")).click();
	        Thread.sleep(2000);
	        driver.switchTo().alert().accept(); // Accept alert

	        driver.findElement(By.id("nava")).click(); // Go back to home
	        Thread.sleep(1000);
	        driver.findElement(By.linkText("Nokia lumia 1520")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.linkText("Add to cart")).click();
	        Thread.sleep(2000);
	        driver.switchTo().alert().accept();
	    }

	    @When("proceeds to checkout")
	    public void proceeds_to_checkout() throws InterruptedException {
	        driver.findElement(By.id("cartur")).click(); // Go to cart
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.id("name")).sendKeys("Nirmal");
	        driver.findElement(By.id("country")).sendKeys("India");
	        driver.findElement(By.id("city")).sendKeys("Theni");
	        driver.findElement(By.id("card")).sendKeys("1234567890123456");
	        driver.findElement(By.id("month")).sendKeys("11");
	        driver.findElement(By.id("year")).sendKeys("2025");
	        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	    }

	    @Then("order should be placed successfully")
	    public void order_should_be_placed_successfully() throws InterruptedException {
	        Thread.sleep(2000);
	        WebElement confirmation = driver.findElement(By.className("sweet-alert"));
	        if (confirmation.isDisplayed()) {
	            System.out.println("Order placed successfully!");
	        } else {
	            System.out.println("Order placement failed.");
	        }
	        driver.quit();
	    }
	}



