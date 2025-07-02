package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.lang.reflect.Method;

import static utils.RandomUtils.generateString;

public class DeleteBoardTests extends AppManager {
    BoardsPage boardsPage;
    MyBoardPage myBoardPage;

    @BeforeMethod
    public void login(Method method){
        User user = User.builder()
                .email("valeriya.qa@gmail.com")
                .password("678512Lera!")
                .build();
        logger.info("start method -->> "
                + method.getName() + "with user data: " + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder()
                .boardTitle(generateString(5)).build();
        boardsPage.createNewBoard(board);
    }

    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));


    }
}