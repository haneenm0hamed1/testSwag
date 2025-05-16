package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PageBase {
    WebDriver driver;
    public PageBase(WebDriver driver) {
        this.driver =driver;
    }

    public static Duration WAIT = Duration.ofSeconds(10L);

    public void waitForElementToBeClickable(By locator){

        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void fillElement(By locator,String value){
        this.waitForElementVisibility(locator);
        this.driver.findElement(locator).sendKeys(value);
    }

    public void clickOnElement(By locator){
        this.waitForElementVisibility(locator);
        this.waitForElementToBeClickable(locator);
        this.driver.findElement(locator).click();

    }

    public String findCurrentURL(WebDriver driver){

        return driver.getCurrentUrl();
    }

    public String getText(WebDriver driver,By locator)
    {
        waitForElementVisibility(locator);
        return driver.findElement(locator).getText();
    }

}