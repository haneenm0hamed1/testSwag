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
        login.fillUserName("error_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
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
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();
        product.clickOnProductTitle();
        String Title = product.getProductDetailsTitle();
        // Add a small delay to ensure the cart updates
        Thread.sleep(5000);
        Assert.assertEquals(Title, "Sauce Labs Backpack");
    }

}




