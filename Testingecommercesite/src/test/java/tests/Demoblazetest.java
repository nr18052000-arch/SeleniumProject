package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

public class Demoblazetest {
    WebDriver driver;
    Loginpagedemo login;
    Productpage product;
    Cartpage cart;
    Checkoutpage checkout;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();

        login = new Loginpagedemo(driver);
        product = new Productpage(driver);
        cart = new Cartpage(driver);
        checkout = new Checkoutpage(driver);
    }

    @Test
    public void testPurchaseFlow() throws InterruptedException {
        // Login
        login.login("nirmalraju19090", "nirmalraju19090");
        Thread.sleep(3000); // wait for login to complete

        // Select first product
        product.selectFirstProduct();
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Go back to home
        driver.findElement(By.xpath("//a[text()='Home ']")).click();
        Thread.sleep(2000);

        // Select second product
        product.selectSecondProduct();
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Go to cart and place order
        cart.goToCart();
        Thread.sleep(2000);
        cart.placeOrder();
        Thread.sleep(2000);

        // Fill checkout form and submit
        checkout.fillForm("nirmal", "india", "chennai", "9090808070706060", "12", "24");
        checkout.submitOrder();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


