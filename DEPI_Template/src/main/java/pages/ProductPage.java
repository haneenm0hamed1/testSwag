package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    By userName = By.id("user-name");
    By password = By.id("password");
    By logInButton = By.id("login-button");
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

    By sortDropdown = By.className("product_sort_container");
    By productNames = By.className("inventory_item_name");
    By productImages = By.cssSelector(".inventory_item_img img");

    public void selectSortOption(String optionText) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(optionText);
    }

    public List<WebElement> getProductNameElements() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductImageElements() {
        return driver.findElements(productImages);
    }
    public List<WebElement> getProductPriceElements() {
        return driver.findElements(By.className("inventory_item_price"));
    }


    public void fillUserName(String username){
        fillElement(userName,username);
        waitForElementVisibility(userName);
    }

    public void fillPassword(String password){
        fillElement(this.password,password);
    }

    public void ClickButton(){
        clickOnElement(logInButton);
    }
}

