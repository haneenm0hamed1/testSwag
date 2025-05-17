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

    // Moo.TC 1

    @Test
    public void test_Login_With_Valid_Data() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful for standard_user.");
        System.out.println("testLoginWithValidData: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    // Moo.TC 3

    @Test
    public void test_Login_With_A_Technical_Broblems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("problem_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        System.out.println("testLoginWithATechnicalBroblems: " + (isLoginSuccessful ? "PASSED" : "FAILED"));

        Assert.assertTrue(isLoginSuccessful, "Login should fail for problem_user.");
    }

    // Moo.TC 4

    @Test
    public void test_Login_With_A_Preformance_Glitch() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("performance_glitch_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful despite performance glitches.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    // Abdelrhman.TC 2

    @Test
    public void test_Login_With_Valid_Data_by_Locked_Out_User() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("locked_out_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should be fail for locked_out_user.");
        System.out.println("testLoginWithValidData: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    // Abdelrhman.TC 5

    @Test
    public void test_Login_With_error_user() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("error_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        System.out.println("testLoginWithATechnicalBroblems: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
        Assert.assertFalse(isLoginSuccessful, "Login should successful for error_user.");
    }

    // Abdelrhman.TC 6

    @Test
    public void Validate_login_with_invalid_username_or_invalid_password() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "Login should be successful for visual_user.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    //ziad.TC 7

    @Test
    public void Invalidate_login_with_a_Invalid_user_and_invalid_password() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("MMM1111");
        login.fillPassword("0000000");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should be fail for invalid user and invalid password.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    //ziad.TC 8

    @Test
    public void Invalidate_login_with_a_valid_user_and_invalid_password() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("standard_user");
        login.fillPassword("0000");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should be fail for valid user and invalid password.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

    //ziad.TC 9

    @Test
    public void Invalidate_login_with_a_invalid_user_and_valid_password() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login.fillUserName("0000000");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000L);
        boolean isLoginSuccessful = login.isLoginSuccessful();
        Assert.assertFalse(isLoginSuccessful, "Login should be fail for invalid user and ٍٍvalid password.");
        System.out.println("testLoginWithAPreformanceGlitch: " + (isLoginSuccessful ? "PASSED" : "FAILED"));
    }

}
