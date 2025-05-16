package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    //element locating
    By ProductTitle = By.className("inventory_item_name");
    By ProductDetailsTitle = By.className("inventory_details_name");
    By AddToCartButton = By.cssSelector(".inventory_item button");
    By CartPageCount = By.cssSelector("span[class='shopping_cart_badge']");
    By RemoveButton = By.name("remove-sauce-labs-backpack");

    public void clickAddToCart() {
        waitForElementToBeClickable(AddToCartButton);
        clickOnElement(AddToCartButton);
    }


    public Integer getCartPageCount() {
        waitForElementVisibility(CartPageCount);
        return (Integer) Integer.parseInt(getText(driver, CartPageCount));
    }


    public void clickOnProductTitle() {
        waitForElementToBeClickable(ProductTitle);
        clickOnElement(ProductTitle);
    }


    public String getProductDetailsTitle() {
        waitForElementVisibility(ProductDetailsTitle);
        return getText(driver, ProductDetailsTitle);
    }


    public void removeFromCart() {
        waitForElementToBeClickable(RemoveButton);
        clickOnElement(RemoveButton);
    }
}

