package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

     public static WebDriver driver;
     @BeforeMethod
     public void openBrowser(){
            driver = new ChromeDriver();
            driver.navigate().to("https://www.saucedemo.com/");
     }


     @AfterMethod
     public void closeBrowser(){
         driver.quit();
     }


}
