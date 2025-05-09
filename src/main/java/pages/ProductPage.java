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

}

