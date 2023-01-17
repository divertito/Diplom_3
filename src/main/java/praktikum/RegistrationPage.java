package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.disappear;

public class RegistrationPage extends CommonInfo {
    //Name
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    public SelenideElement registrationName;
    //Registration button
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registrationButton;
    //Error
    @FindBy(how = How.XPATH, using = ".//p[contains(@class,'input__error')]")
    public SelenideElement error;

    public void setRegistrationName(String name) {
        registrationName.setValue(name);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public String getError() {
        String errorMessage = error.getText();
        return errorMessage;
    }

    public void waitTime() {
        registrationName.should(disappear);
    }

    public void signUp(String name, String email, String password) {
        setRegistrationName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }
}
