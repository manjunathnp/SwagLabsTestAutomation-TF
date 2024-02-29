package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    // Checkout Page Web Elements
    @FindBy(name = "firstName")
    WebElement firstNameTxtFld;

    @FindBy(name = "lastName")
    WebElement lastNameTxtFld;

    @FindBy(name = "postalCode")
    WebElement postalTxtFld;

    @FindBy(name = "continue")
    WebElement continueBtn;

    // Checkout Page Action Methods
    public void enterUserInfo(String firstName, String lastName, String postalCode){
        firstNameTxtFld.sendKeys(firstName);
        lastNameTxtFld.sendKeys(lastName);
        postalTxtFld.sendKeys(postalCode);
        continueBtn.click();
    }

}
