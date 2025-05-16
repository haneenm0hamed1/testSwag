package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.HomePage;

public class CartTest extends TestBase {

    LoginPage login;
    HomePage products;
    CartPage cart;

    @BeforeMethod
    public void setup() {
        login = new LoginPage(driver);
        products = new HomePage(driver);
        cart = new CartPage(driver);

        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
    }

    /// TC_ID_Swag_Cart_02
    @Test
    public void validatePriceDisplayInCart() {

        String productPrice = products.getFirstProductPrice();

        products.addFirstProductToCart();
        products.goToCart();

        String cartPrice = cart.getCartItemPrice();

        Assert.assertEquals(cartPrice, productPrice, "Price doesn't match between product and cart!");
    }
}