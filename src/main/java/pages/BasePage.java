package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd){
        driver = wd;
    }

    public void clickWait(WebElement element, int time){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .elementToBeClickable(element)).click();
    }

    public boolean validateTextInElementWait(WebElement element, String text, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}