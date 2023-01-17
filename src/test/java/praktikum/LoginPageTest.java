package praktikum;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class LoginPageTest {
    LoginPage signInUser;

    @Before
    public void setUp() {
        signInUser = open("https://stellarburgers.nomoreparties.site", LoginPage.class);
    }

    @After
    public void tearDown() {
        signInUser.clickAccountButton();
        signInUser.clickSignOutButton();
        signInUser.signIn.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginUsingSignInButtonTest() {
        signInUser.clickSignInButton();
        signInUser.signIn("Qwerty@qw.com", "Qwerty1!");
        String expected = "Соберите бургер";
        String actual = signInUser.getMainPageHeader();
        assertEquals("Login was failed", expected, actual);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginUsingAccountButtonTest() {
        signInUser.clickAccountButton();
        signInUser.signIn("Qwerty@qw.com", "Qwerty1!");
        String expected = "Соберите бургер";
        String actual = signInUser.getMainPageHeader();
        assertEquals("Login was failed", expected, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginUsingRegistrationButtonTest() {
        signInUser.clickAccountButton();
        signInUser.clickSignUpLink();
        signInUser.clickSignInLink();
        signInUser.signIn("Qwerty@qw.com", "Qwerty1!");
        String expected = "Соберите бургер";
        String actual = signInUser.getMainPageHeader();
        assertEquals("Login was failed", expected, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    public void loginUsingForgotPasswordButtonTest() {
        signInUser.clickAccountButton();
        signInUser.clickForgotPasswordLink();
        signInUser.clickSignInLink();
        signInUser.signIn("Qwerty@qw.com", "Qwerty1!");
        String expected = "Соберите бургер";
        String actual = signInUser.getMainPageHeader();
        assertEquals("Login was failed", expected, actual);
    }
}
