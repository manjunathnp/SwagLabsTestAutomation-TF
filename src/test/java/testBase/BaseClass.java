package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties properties;

    @BeforeClass(groups = {"master"})
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws IOException {

        // Loading config.properties File
        FileReader file = new FileReader("src/test/resources/config.properties");
        properties = new Properties();
        properties.load(file);

        // Loading log4j2.xml File
        logger = LogManager.getLogger(this.getClass());

        // Launching Browser based on condition
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("CHROME Browser launched");
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("FIREFOX Browser launched");
                break;

            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                logger.info("SAFARI Browser launched");
                break;

            default:
                System.out.println("No matching browsers");
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"//screenshots//" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }


    @AfterClass(groups = {"master"})
    public void tearDown(){
        driver.quit();
    }
}
