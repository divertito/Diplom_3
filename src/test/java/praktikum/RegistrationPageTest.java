package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegistrationPageTest {
    RegistrationPage signUpUser;
    String randomName;
    String randomPassword;
    String randomEmail;
    User user;
    UserClient userClient;

    @Before
    public void setUp() {
        signUpUser = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        randomName = RandomStringUtils.randomAlphabetic(8);
        randomEmail = RandomStringUtils.randomAlphabetic(8) + "@qwerty.com";
        randomPassword = RandomStringUtils.randomAlphabetic(10);
        user = new User(randomEmail, randomPassword);
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        if (userClient.login(user).extract().path("accessToken") != null) {
            userClient.delete(user, userClient.login(user).extract().path("accessToken"));
        }
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registrationUsingAccountButtonTest() {
        signUpUser.signUp(randomName, randomEmail, randomPassword);
        signUpUser.waitTime();
        String expected = "Вход";
        String actual = signUpUser.getSignUpInPageHeader();
        assertEquals("Registration was failed or login page wasn't opened", expected, actual);
    }

    @Test
    @DisplayName("Регистрация нового пользователя с невалидным паролем")
    public void registrationWithIncorrectPasswordTest() {
        signUpUser.signUp(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8) + "@qwerty.com", RandomStringUtils.randomAlphabetic(5));
        String expected = "Некорректный пароль";
        String actual = signUpUser.getError();
        assertEquals("User with incorrect password was created", expected, actual);
    }
}
