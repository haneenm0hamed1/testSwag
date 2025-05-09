package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.util.*;

public class ProductTest extends TestBase {

    @DataProvider(name = "sortOptions")
    public Object[][] sortOptions() {
        return new Object[][] {
                {"Name (A to Z)", true},
                {"Name (Z to A)", true},
                {"Price (low to high)", false},
                {"Price (high to low)", false}
        };
    }

    @Test(dataProvider = "sortOptions")
    public void verifySorting(String sortOption, boolean isNameSort) {
        LoginPage login = new LoginPage(driver);
        login.fillUserName("standard_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSortOption(sortOption);

        if (isNameSort) {
            List<WebElement> elements = productPage.getProductNameElements();
            List<String> actualNames = new ArrayList<>();
            for (WebElement el : elements) {
                actualNames.add(el.getText());
            }

            List<String> sortedNames = new ArrayList<>(actualNames);
            if (sortOption.equals("Name (Z to A)")) {
                Collections.sort(sortedNames, Collections.reverseOrder());
            } else {
                Collections.sort(sortedNames);
            }

            Assert.assertEquals(actualNames, sortedNames);
        } else {

            List<WebElement> priceElements = productPage.getProductPriceElements();
            List<Double> actualPrices = new ArrayList<>();
            for (WebElement el : priceElements) {
                actualPrices.add(Double.parseDouble(el.getText().replace("$", "")));
            }

            List<Double> sortedPrices = new ArrayList<>(actualPrices);
            if (sortOption.equals("Price (high to low)")) {
                Collections.sort(sortedPrices, Collections.reverseOrder());
            } else {
                Collections.sort(sortedPrices);
            }

            Assert.assertEquals(actualPrices, sortedPrices);
        }
    }

    @Test
    public void verifyUniqueImages() {
        LoginPage login = new LoginPage(driver);
        login.fillUserName("problem_user");
        login.fillPassword("secret_sauce");
        login.ClickButton();

        ProductPage productPage = new ProductPage(driver);
        List<WebElement> images = productPage.getProductImageElements();

        List<String> srcList = new ArrayList<>();
        for (WebElement img : images) {
            srcList.add(img.getAttribute("src"));
        }

        Set<String> uniqueImages = new HashSet<>(srcList);
        Assert.assertEquals(uniqueImages.size(), srcList.size(), "Some product images are duplicated.");
    }
}
