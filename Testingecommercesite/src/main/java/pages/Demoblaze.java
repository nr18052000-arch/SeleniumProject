package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demoblaze {
	   public static void main(String[] args) throws  InterruptedException, IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://www.demoblaze.com/");
			driver.manage().window().maximize();
	       
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        // Login
	        driver.findElement(By.id("login2")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("nirmalraju19090");
	        driver.findElement(By.id("loginpassword")).sendKeys("nirmalraju19090");
	        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

	        // Wait for login to complete
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

	        // Add first product
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='hrefch'])[5]"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();

	        // Go back to home
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Home ']"))).click();

	        // Add second product
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='hrefch'])[6]"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();

	        // Go to cart
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

	        // Place order
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();

	        // Fill order form
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("nirmal");
	        driver.findElement(By.id("country")).sendKeys("india");
	        driver.findElement(By.id("city")).sendKeys("chennai");
	        driver.findElement(By.id("card")).sendKeys("9090808070706060");
	        driver.findElement(By.id("month")).sendKeys("12");
	        driver.findElement(By.id("year")).sendKeys("24");

	        // Purchase
	        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

	     // Print confirmation
	        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//p")));
	        System.out.println("Order placed: " + confirmation.getText());

	        // Screenshot
	        File firstfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(firstfile, new File("ordercompleted.png"));

	        // Close browser
	        driver.quit();

	       
  }
}