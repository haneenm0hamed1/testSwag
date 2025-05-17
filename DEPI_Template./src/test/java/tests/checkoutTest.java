package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.checkoutpage;
import pages.LoginPage;

public class checkoutTest extends TestBase {

    LoginPage login;
    checkoutpage checkout;

    @BeforeMethod
    public void setPages() {
        login = new LoginPage(driver);
        checkout = new checkoutpage(driver);
    }

    // TC-7: Valid checkout information
    @Test
    public void Tc_Swag_checkout_007_validInfo() {
        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(1000);
        checkout.openCart();
        checkout.sleep(1000);
        checkout.clickCheckout();
        checkout.sleep(1000);

        checkout.enterCheckoutInformation("Hagar", "Abdallah", "1233");

        String actualTitle = checkout.getCurrentStepTitle();
        Assert.assertEquals(actualTitle, "Checkout: Overview", "User should proceed to the overview step.");
    }

    // TC-8: Invalid checkout information
    @Test
    public void Tc_Swag_checkout_008_invalidInfo() {
        login.fillUserName("visual_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(1000);
        checkout.openCart();
        checkout.sleep(1000);
        checkout.clickCheckout();
        checkout.sleep(1000);

        checkout.enterCheckoutInformation("Hagar", "عبدالله", "122er");
        checkout.sleep(1000);

        checkout.finishCheckout();

        // Here you can add assertions to verify behavior after trying to finish with invalid info if needed
    }

    // TC-3: Checkout process with problem_user, last name should be rejected
    @Test
    public void Tc_Swag_checkout_003_problemUser_LastNameRejected() {
        login.fillUserName("problem_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(1000);
        checkout.openCart();
        checkout.sleep(1000);
        checkout.clickCheckout();
        checkout.sleep(1000);

        // Intentionally using invalid last name to test rejection
        checkout.enterCheckoutInformation("Hagar", "   ", "12345");
        checkout.sleep(1000);

        // Check error message for last name field rejection
        String errorMessage = checkout.getErrorMessage();
        Assert.assertTrue(errorMessage.toLowerCase().contains("last name") || errorMessage.toLowerCase().contains("error"),
                "Expected error message related to last name field.");
    }

    // TC-5: Checkout accepts space-only inputs with performance_glitch_user and completes successfully despite delays
    @Test
    public void Tc_Swag_checkout_005_spaceOnlyInputs_performanceGlitchUser() {
        login.fillUserName("performance_glitch_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(3000); // Extra wait for slow performance simulation
        checkout.openCart();
        checkout.sleep(2000);
        checkout.clickCheckout();
        checkout.sleep(2000);

        // Enter spaces only in all required fields
        checkout.enterCheckoutInformation(" ", " ", " ");
        checkout.sleep(3000); // Wait for slow performance

        // Check if it proceeds to Overview page successfully
        String actualTitle = checkout.getCurrentStepTitle();
        Assert.assertEquals(actualTitle, "Checkout: Overview", "Checkout should complete despite space-only inputs.");
        // Optional: finish checkout to complete flow
        checkout.finishCheckout();
        // Could add assertion here to confirm final success if applicable
    }
    // TC-
    @Test
    public void testStandardUserCheckoutSimple() {
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(1000);
        checkout.openCart();
        checkout.sleep(1000);
        checkout.clickCheckout();
        checkout.sleep(1000);

        checkout.enterCheckoutInformation("joo", "emad", "333");

        String actualTitle = checkout.getCurrentStepTitle();
        Assert.assertEquals(actualTitle, "Checkout: Overview", "User should proceed to the overview step.");
    }
    //tc-1
    @Test
    public void testErrorUserCheckoutSimple() {
        login.fillUserName("error_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        checkout.waitForElementVisibility(By.id("add-to-cart-sauce-labs-backpack"));
        checkout.addProductToCart();
        checkout.sleep(1000);
        checkout.openCart();
        checkout.sleep(1000);
        checkout.clickCheckout();
        checkout.sleep(1000);

        checkout.enterCheckoutInformation("youssef", "emad", "777");

        String actualTitle = checkout.getCurrentStepTitle();
        Assert.assertEquals(actualTitle, "Checkout: Overview", "User should proceed to the overview step.");
    }
}