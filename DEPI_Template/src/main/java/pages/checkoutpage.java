package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutpage extends PageBase {

    public checkoutpage(WebDriver driver) {
        super(driver);
    }

    // Elements
    By checkoutTitle = By.className("title");

    // Methods
    public boolean isCheckoutPageLoaded() {
        waitForElementVisibility(checkoutTitle);
        String actualTitle = driver.findElement(checkoutTitle).getText().trim();
        return actualTitle.equalsIgnoreCase("Checkout: Your Information");
    }
}