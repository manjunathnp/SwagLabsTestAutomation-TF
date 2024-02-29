package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{
    WebDriver driver;

    public OverviewPage(WebDriver driver){
        super(driver);
    }

    // Overview Page Web Elements
    @FindBy(name = "finish")
    WebElement finishBtn;


    // Overview Page Action Methods
    public void clickFinishBtn(){
        finishBtn.click();
    }
}
