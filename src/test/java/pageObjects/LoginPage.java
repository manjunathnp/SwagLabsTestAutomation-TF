package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    // Web Elements
    @FindBy(id = "user-name")
    WebElement usernameTxtFld;

    @FindBy(id = "password")
    WebElement passwordTxtFld;

    @FindBy(id = "login-button")
    WebElement loginBtn;


    // Action methods
    public void setUsername(String username){
        usernameTxtFld.sendKeys(username);
    }

    public void setPassword(String password){
        passwordTxtFld.sendKeys(password);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public boolean loginBtnPresence(){
        return loginBtn.isDisplayed();
    }

}
