package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Checkoutpage extends TestBase {

    // Tc_Swag_checkout_002
    @Test
    public void lastNameFieldBugTest() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("TestFirst");
        Thread.sleep(500);
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("TestLast");
        Thread.sleep(500);
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(500);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualError = errorMessage.getText();
        String expectedError = "Error: Last Name is required";
        Assert.assertEquals(actualError, expectedError, "BUG not reproduced: Last Name should still show error!");
    }
    // Tc_Swag_checkout_003
    @Test
    public void lockedOutUserCannotLogin() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualError = errorMessage.getText();
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualError, expectedError, "BUG: Locked out user was able to login!");
    }

    // Tc_Swag_checkout_005
    @Test
    public void checkoutAcceptsSpacesBugTest() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys("   ");
        Thread.sleep(500);
        driver.findElement(By.id("last-name")).sendKeys("   ");
        Thread.sleep(500);
        driver.findElement(By.id("postal-code")).sendKeys("   ");
        Thread.sleep(500);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        String currentUrl = driver.getCurrentUrl();
        boolean isBugPresent = currentUrl.contains("checkout-step-two.html");
        Assert.assertTrue(isBugPresent, "Validation is working fine, Bug NOT reproduced.");
    }


}
