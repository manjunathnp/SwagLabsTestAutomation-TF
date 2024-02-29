package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.time.Duration;

public class LoginTest extends BaseClass {

    @Test(groups = {"master"})
    public void validateRegisteredUserLogin(){

        logger.info("***** STARTING LoginTest *****");

        try{
            LoginPage loginPage = new LoginPage(driver);

            logger.info("Entering Registered User Credentials.....");
            loginPage.setUsername(properties.getProperty("username"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();
            logger.info("Clicked on Login Button.....");

            HomePage homePage = new HomePage(driver);

            String appLogoText = homePage.homePageLogoText();
            String productsText = homePage.productsTitleText();

            logger.info("Validating User Login.....");
            if(appLogoText.equals("Swag Labs") & productsText.equals("Products")){
                logger.info("User Login Successful.....");
                Assert.assertTrue(true);
            }else{
                logger.info("User Login Unsuccessful.....");
                Assert.fail();
            }

            homePage.clickLogoutLink();
            logger.info("Validating User Logout.....");
            if(loginPage.loginBtnPresence()){
                logger.info("User Logout Successful.....");
                Assert.assertTrue(true);
            }else{
                logger.info("User Logout Unsuccessful.....");
                Assert.fail();
            }
        }
        catch (Exception e){
            logger.error("***** TEST FAILURE *****");
            Assert.fail();
        }

        logger.info("***** ENDING LoginTest *****");
    }
}
