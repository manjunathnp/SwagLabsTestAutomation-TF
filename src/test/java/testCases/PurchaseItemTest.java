package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class PurchaseItemTest extends BaseClass {

    @Test
    public void purchaseItemEndToEndValidation(){
        logger.info("***** STARTING PurchaseItemTest *****");

        try{
            LoginPage loginPage = new LoginPage(driver);

            logger.info("Entering Registered User Credentials.....");
            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();
            logger.info("Clicked on Login Button.....");

            HomePage homePage = new HomePage(driver);
            homePage.addItemToCart();
            logger.info("Item added to cart.....");

            homePage.clickCartIcon();
            logger.info("Clicked on cart.....");

            CartPage cartPage = new CartPage(driver);
            cartPage.clickCheckOutBtn();
            logger.info("Clicked on Checkout button.....");

            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.enterUserInfo("tester", "testing", "10001");
            logger.info("Entered User Information.....");

            OverviewPage overviewPage = new OverviewPage(driver);
            overviewPage.clickFinishBtn();
            logger.info("Clicked on Finish button.....");

            CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
            if(checkoutCompletePage.orderComplete()){
                logger.info("Item purchase successful!");
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }catch (Exception e){
            logger.error("***** TEST FAILURE *****");
            Assert.fail();
        }
        logger.info("***** ENDING PurchaseItemTest *****");
    }
}
