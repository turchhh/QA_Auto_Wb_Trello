package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBoardPage1 extends BasePage {

    // Локаторы вместо WebElement
    private By menuDots = By.xpath("//button[@class='GDunJzzgFqQY_3 frrHNIWnTojsww bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc']");
    private By closeBoard = By.xpath("//div[text()='Close board']");
    private By closeBtn = By.xpath("//button[text()='Close']");
    private By menuDots1 = By.xpath("//button[@class='GDunJzzgFqQY_3 frrHNIWnTojsww bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc']");
    private By deleteBoardBtn = By.xpath("//button[@class='Bp80TGmc9hQIdE WG_eo5n8x2vHvI bxgKMAm3lq5BpA V_9lMAQOdk_AYt SEj5vUdI3VvxDc']");
    private By deleteBtn = By.xpath("//button[text()='Delete']");

    // Элемент для проверки названия доски — тут можно оставить WebElement,
    // т.к. валидация текста, вероятно, работает с актуальным элементом
    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    public MyBoardPage1(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    // Универсальный метод клика с ожиданием и повторными попытками
    public void clickWait(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                // Можно добавить Thread.sleep(200) для небольшой паузы
            }
        }
        throw new RuntimeException("Не удалось кликнуть по элементу после 3 попыток: " + locator);
    }

    public void deleteBoard() {
        clickWait(menuDots, 3);
        clickWait(closeBoard, 3);
        clickWait(closeBtn, 3);
        clickWait(menuDots1, 3);
        clickWait(deleteBoardBtn, 10);
        clickWait(deleteBtn, 3);
    }

    public boolean validateBoardName(String text, int time) {
        return validateTextInElementWait(boardName, text, time);
    }
}
