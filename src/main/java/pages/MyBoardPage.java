package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage {
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;
    @FindBy(xpath = "//button[@aria-label='Show menu']")
    WebElement btnMenuDots;
    @FindBy(xpath = "//div[text()='Close board']")
    //@FindBy(xpath = "//span[@aria-label='Close board']/..") //если русский язык
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDelete;

    public void deleteBoard() {
        clickWait(btnMenuDots, 3);
        clickWait(btnCloseBoard, 3);
        clickWait(btnClose, 3);
        pause(2);
        clickWait(btnMenuDots, 3);
        clickWait(btnDeleteBoard, 3);
        clickWait(btnDelete, 3);

    }

    public boolean validateBoardName(String text, int time) {
        return validateTextInElementWait(boardName, text, time);
    }
}