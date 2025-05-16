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
    // standard_user

    @Test
    public void testLoginWithValidData() throws InterruptedException {
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
    // problem_user

    @Test
    public void testLoginWithATechnicalBroblems() throws InterruptedException {
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
    // performance_glitch_user

    @Test
    public void testLoginWithAPreformanceGlitch() throws InterruptedException {
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

    // Abdelrhman.TC 2
    // Locked Out User

    @Test
    public void testLoginWithValidDatabyLockedOutUser() throws InterruptedException {
        login.fillUserName("locked_out_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should be fail for locked_out_user.");
        System.out.println("testLoginWithValidData: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    // Abdelrhman.TC 5
    // error User

    @Test
    public void testLoginWitherroruser() throws InterruptedException {
        login.fillUserName("error_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        System.out.println("testLoginWithATechnicalBroblems: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
        Assert.assertTrue(isLoginSuccessful, "Login should successful for error_user.");
    }

    // Abdelrhman.TC 6
    //visual User

    @Test
    public void testLoginWithvisual_user() throws InterruptedException {
        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink, "https://www.saucedemo.com/inventory.html");
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful for visual_user.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

}
