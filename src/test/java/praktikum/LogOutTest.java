package praktikum;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class LogOutTest {
    LoginPage logOutUser;
    @Before
    public void setUp() {
        logOutUser = open("https://stellarburgers.nomoreparties.site", LoginPage.class);
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете.")
    public void switchToAccountTest() {
        logOutUser.clickAccountButton();
        logOutUser.signIn("Qwerty@qw.com", "Qwerty1!");
        logOutUser.clickAccountButton();
        logOutUser.clickSignOutButton();
        logOutUser.pageSignUpInHeader.shouldBe(Condition.visible);
        String expected = "Вход";
        String actual = logOutUser.getSignUpInPageHeader();
        assertEquals("Logout was failed", expected, actual);
    }
}
