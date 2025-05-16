package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage login;

    @BeforeMethod
    public void setLogin() {
        login = new LoginPage(driver);
    }
    // Moo.TC 1
    @Test
    public void testLoginWithValidData() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful for standard_user.");
        System.out.println("testLoginWithValidData: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }
    // Moo.TC 3
    @Test
    public void testLoginWithATechnicalBroblems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("problem_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        System.out.println("testLoginWithATechnicalBroblems: " + (isLoginSuccessful ? "PASSED" : "FAILED"));

        Assert.assertTrue(isLoginSuccessful, "Login should fail for problem_user.");
    }
    // Moo.TC 4
    @Test
    public void testLoginWithAPreformanceGlitch() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("performance_glitch_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful despite performance glitches.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    @Test
    public void testLoginWithINValidData() throws InterruptedException {
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauc");
        login.ClickButton();
        Thread.sleep(5000);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink,"https://www.saucedemo.com/");
    }

    @Test
    public void testLoginWithINValidDataErrorMessage() throws InterruptedException {
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauc");
        login.ClickButton();
        Thread.sleep(5000);
        String errorMessage = login.getErrorMessage();
        System.out.println("Menna need to see this" + errorMessage);
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
    }

}
