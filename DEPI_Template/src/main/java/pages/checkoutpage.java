package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class checkoutpage extends PageBase {

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By errorMsg = By.cssSelector("[data-test='error']");
    By stepTitle = By.className("title");

    public checkoutpage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        clickOnElement(addToCartBtn);
    }
    public void openCart() {
        waitForElementVisibility(cartIcon);
        waitForElementToBeClickable(cartIcon);

        // Scroll into view before clicking
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(cartIcon));

        // JS click to avoid click interception issues
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(cartIcon));
    }
    public void clickCheckout() {
        waitForElementVisibility(checkoutBtn);
        waitForElementToBeClickable(checkoutBtn);
        clickOnElement(checkoutBtn);
    }
    public void enterCheckoutInformation(String fName, String lName, String zip) {
        fillElement(firstName, fName);
        fillElement(lastName, lName);
        fillElement(postalCode, zip);
        clickOnElement(continueBtn);
    }
    public void finishCheckout() {
        waitForElementVisibility(finishBtn);
        waitForElementToBeClickable(finishBtn);
        clickOnElement(finishBtn);
    }

    public String getCurrentStepTitle() {
        return getText(driver, stepTitle);
    }

    public String getErrorMessage() {
        return getText(driver, errorMsg);

    }
}