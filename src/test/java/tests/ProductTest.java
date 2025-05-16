package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends TestBase{
    LoginPage login;
    ProductPage product;

    @BeforeMethod
    public void setUpPages() {
        login = new LoginPage(driver);
        product = new ProductPage(driver);
    }

    //TC_Swag_Product_004
    @Test
    public void testRemoveProductFromCart() throws InterruptedException {
        login.login("error_user","secret_sauce");
        product.clickAddToCart();
        product.removeFromCart();
        // Add a small delay to ensure the cart updates
        Thread.sleep(5000);
        Integer cartCount= product.getCartPageCount();
        Assert.assertEquals(cartCount,  0,"Product was not deleted from the cart");
    }
    //TC_Swag_Product_006
    @Test
    public void testOpenProductDetailsPage() throws InterruptedException{
        login.login("standard_user", "secret_sauce");
        product.clickOnProductTitle();
        String Title = product.getProductDetailsTitle();
        // Add a small delay to ensure the cart updates
        Thread.sleep(5000);
        Assert.assertEquals(Title, "Sauce Labs Backpack");
    }

}




