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

    public void fillUserName(String username){
        fillElement(userName,username);
    }

    public void fillPassword(String password){
        fillElement(this.password,password);
    }

    public void ClickButton(){
        clickOnElement(loginButton);
    }

    public void login(String username, String password){
        fillUserName(username);
        fillPassword(password);
        ClickButton();
    }


}
