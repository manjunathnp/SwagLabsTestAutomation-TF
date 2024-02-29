package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
    }

    // Cart Page Web Elements
    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    // Cart Page Action Methods
    public void clickCheckOutBtn(){
        checkOutBtn.click();
    }
}
