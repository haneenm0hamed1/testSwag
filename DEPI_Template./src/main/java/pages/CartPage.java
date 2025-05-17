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


    WebDriver driver;
    By cartIcon = By.className("shopping_cart_link");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    // Methods
    public String getCartItemPrice() {
        waitForElementVisibility(cartItemPrice);
        return driver.findElement(cartItemPrice).getText();
    }



    public void openCart() {
        clickOnElement(cartIcon);
    }


    public void clickCheckout() {
        clickOnElement(checkoutButton);
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("cart");
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains("checkout-step-one");
    }
    public void fillCheckoutForm(String firstName, String lastName, String zip) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public boolean isOnCheckoutStepTwo() {
        return driver.getCurrentUrl().contains("checkout-step-two");
    }

}