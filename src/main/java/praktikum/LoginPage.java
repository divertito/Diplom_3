package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends CommonInfo {
    //Sign in button
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement signIn;
    //Sign in link from registration page
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement signInLink;
    //Forgot password link
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    public SelenideElement forgotPasswordLink;


    public void clickSignIn() {
        signIn.click();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void signIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }
}
