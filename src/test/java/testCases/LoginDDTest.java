package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void validateRegisteredUserLoginDataDrivenTest(String username, String password, String result){
        logger.info("***** STARTING validateRegisteredUserLoginDataDrivenTest *****");

        try{
            LoginPage loginPage = new LoginPage(driver);
            logger.info("Entering Registered User Credentials.....");
            loginPage.setUsername(username);
            loginPage.setPassword(password);
            loginPage.clickLogin();
            logger.info("Clicked on Login Button.....");

            HomePage homePage = new HomePage(driver);
            boolean targetPageExists = homePage.homePageExists();

            if(result.equalsIgnoreCase("valid")){
                if(targetPageExists){
                    homePage.clickLogoutLink();
                    Assert.assertTrue(true);
                }else{
                    Assert.assertTrue(false);
                }
            }

            if(result.equalsIgnoreCase("invalid")){
                if(targetPageExists){
                    homePage.clickLogoutLink();
                    Assert.assertTrue(false);
                }else{
                    Assert.assertTrue(true);
                }
            }

        }catch(Exception e){
            Assert.fail();
        }
        logger.info("***** ENDING validateRegisteredUserLoginDataDrivenTest *****");

    }
}
