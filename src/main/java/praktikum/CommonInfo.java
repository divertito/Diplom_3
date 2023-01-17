package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonInfo {
    //Registration link
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    public SelenideElement signUpLink;
    //SignIn button
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public SelenideElement signInButton;
    //Account button
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    public SelenideElement accountButton;
    //Sign out button
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public SelenideElement signOutButton;
    //Burger Constructor
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    public SelenideElement burgerConstructor;
    //Page Logo
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    public SelenideElement pageLogo;
    //Main page Header
    @FindBy(how = How.XPATH, using = ".//h1")
    public SelenideElement mainPageHeader;
    //Sign in_up pages Header
    @FindBy(how = How.XPATH, using = ".//h2")
    public SelenideElement pageSignUpInHeader;

    //Email
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    public SelenideElement Email;
    //Password
    @FindBy(how = How.NAME, using = "Пароль")
    public SelenideElement Password;

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickSignOutButton() {
        signOutButton.click();
    }

    public void clickBurgerConstructorButton() {
        burgerConstructor.click();
    }

    public void clickPageLogo() {
        pageLogo.click();
    }

    public String getMainPageHeader() {
        String headerMainPage = mainPageHeader.getText();
        return headerMainPage;
    }

    public String getSignUpInPageHeader() {
        String headerLogin = pageSignUpInHeader.getText();
        return headerLogin;
    }

    public void clickSignUpLink() {
        signUpLink.click();
    }

    public void setEmail(String email) {
        Email.setValue(email);
    }

    public void setPassword(String password) {
        Password.setValue(password);
    }
}
