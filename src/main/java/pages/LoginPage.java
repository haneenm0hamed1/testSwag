package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver){
        super(driver);
    }


    //Element locating
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");
    public void login(String user, String pass) {
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }


    public void fillUserName(String username){
        fillElement(userName,username);
    }

    public void fillPassword(String password){
        fillElement(this.password,password);
    }

    public void ClickButton(){
        clickOnElement(loginButton);
    }

    public String getErrorMessage(){
        return getText(driver,errorMessage);
    }


}
