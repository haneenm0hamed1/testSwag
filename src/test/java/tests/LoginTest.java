package tests;

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

        login.login("standard_user","secret_sauce");
        Thread.sleep(5000);
    }



}
