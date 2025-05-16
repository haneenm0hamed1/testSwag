package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    By cartItemPrice = By.className("inventory_item_price");
    By checkoutButton = By.id("checkout");

    // Methods
    public String getCartItemPrice() {
        waitForElementVisibility(cartItemPrice);
        return driver.findElement(cartItemPrice).getText();
    }

    By cartIcon = By.className("shopping_cart_link");


    public void openCart() {
        clickOnElement(cartIcon);
    }


    public void clickCheckout() {
        clickOnElement(checkoutButton);
    }
}