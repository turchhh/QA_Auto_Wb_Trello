package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {

    public Logger logger = LoggerFactory.getLogger(AppManager.class);
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    static String browser = System.getProperty("browser", "chrome");

    public AppManager(){
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
//        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");

        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Use Chrome");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Use FireFox");
                break;
            default:
                driver = new ChromeDriver();
                logger.info("Use Chrome");
                break;
        }
        driver.manage().window().maximize();
        logger.info("Start testing with method  " + method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method){
        logger.info("Stop testing " + method.getName());
        if (driver != null)
            driver.quit();
    }
}