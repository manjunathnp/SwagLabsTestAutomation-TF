package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{
    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
    }

    // Checkout Complete Page Web Elements
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
    WebElement orderCompleteMsg;


    // Checkout Complete Page Action Methods
    public boolean orderComplete(){
        return orderCompleteMsg.isDisplayed();
    }


}
