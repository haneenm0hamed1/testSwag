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

    @Test
    public void testLoginWithValidData() throws InterruptedException {
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink,"https://www.saucedemo.com/inventory.html");
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
