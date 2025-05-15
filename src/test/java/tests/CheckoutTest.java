package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.HomePage;

public class CheckoutTest extends TestBase {

    LoginPage login;
    HomePage products;
    CartPage cart;
    CheckoutPage checkout;

    @BeforeMethod
    public void setup() {
        login = new LoginPage(driver);
        products = new HomePage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);

        login.login("standard_user","secret_sauce");

        products.addFirstProductToCart();
        products.goToCart();
    }

        /// TC_ID_Swag_Cart_03
    @Test
    public void validateCheckoutButtonFunction() {
        cart.clickCheckout();
        Assert.assertTrue(checkout.isCheckoutPageLoaded(), "Checkout page didn't load!");
    }
}