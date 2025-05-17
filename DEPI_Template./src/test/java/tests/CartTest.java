package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.HomePage;

public class CartTest extends TestBase {

    LoginPage login;
    HomePage products;
    CartPage cart;
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
        login = new LoginPage(driver);
        products = new HomePage(driver);
        cart = new CartPage(driver);


        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        login.login("visual_user", "secret_sauce");

        driver = new ChromeDriver();
        LoginPage login;
        login = new LoginPage(driver);
        CartPage cart = new CartPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        Thread.sleep(5000);
        String Weblink = login.findCurrentURL(driver);
        Assert.assertEquals(Weblink,"https://www.saucedemo.com/inventory.html");





    }


    /*  Start TC_ID_Swaglabs_Cart_01*/
    /* Validate Cart Page icon*/
    @Test
    public void testCartIconNavigation() throws InterruptedException {
        CartPage cart = new CartPage(driver);
        cart.clickCartIcon();
        Assert.assertTrue(cart.isOnCartPage(), "Cart page did not open.");
        Thread.sleep(5000);

    }
    /*  End TC_ID_Swaglabs_Cart_01*/

    /// TC_ID_Swag_Cart_02
    @Test
    public void validatePriceDisplayInCart() {

        String productPrice = products.getFirstProductPrice();

        products.addFirstProductToCart();
        products.goToCart();

        String cartPrice = cart.getCartItemPrice();

        Assert.assertEquals(cartPrice, productPrice, "Price doesn't match between product and cart!");
    }


    /*  Start TC_ID_Swaglabs_Cart_04*/
    /*Validate the login in the checkout*/
    @Test
    public void testLoginInCheckout() {
        CartPage cart = new CartPage(driver);
        login = new LoginPage(driver);
        // Login to the site
        login.login("standard_user", "secret_sauce");
        // Navigate to cart
        cart.clickCartIcon();
        // Click checkout
        cart.clickCheckoutButton();
        // Assert that we are on the checkout step one page
        Assert.assertTrue(cart.isOnCheckoutPage(), "Did not navigate to checkout page.");

        cart.fillCheckoutForm("Ahmed", "Ali","12345");
        Assert.assertTrue(cart.isOnCheckoutStepTwo(), "Failed to navigate to the checkout-step-two zip page");

    }
    /*  End TC_ID_Swaglabs_Cart_04*/



    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}