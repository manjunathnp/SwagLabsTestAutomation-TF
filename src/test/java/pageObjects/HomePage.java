package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
    }

    // Home Page Web Elements
    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "title")
    WebElement productsTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement homePageHambMenu;

    @FindBy(xpath = "//div[div[2][div[1][a[div[normalize-space()='Sauce Labs Backpack']]]]]//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement selectSauceLabsBackupItem;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;


    // Home Page Action Methods
    public String homePageLogoText(){
        return appLogo.getText();
    }

    public String productsTitleText(){
        return productsTitle.getText();
    }

    /*public void clickOnHambMenu(){
        homePageHambMenu.click();
    }*/

    public void clickLogoutLink(){
        homePageHambMenu.click();
        logoutLink.click();
    }

    public boolean homePageExists(){
        try{
            return (productsTitle.isDisplayed());
        }catch (Exception e){
            return (false);
        }
    }

    public void addItemToCart(){
        selectSauceLabsBackupItem.click();
    }

    public void clickCartIcon(){
        cartIcon.click();
    }

}
