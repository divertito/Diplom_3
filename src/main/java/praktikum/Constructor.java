package praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Constructor extends CommonInfo {
    //Buns tab
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    public SelenideElement bunsTab;
    //Souse tab
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public SelenideElement sauceTab;
    //Filling tab
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public SelenideElement fillingTab;
    //Buns label
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    public SelenideElement bunsLabel;
    //Souse label
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    public SelenideElement sauceLabel;
    //Filling label
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    public SelenideElement fillingLabel;

    public void clickBunsTab() {
        bunsTab.click();
    }

    public void clickSauseTab() {
        sauceTab.click();
    }

    public void clickFillingTab() {
        fillingTab.click();
    }

    public String checkBunsLabel() {
        String labelBun = bunsLabel.getText();
        return labelBun;
    }

    public String checkSauceLabel() {
        String labelSauce = sauceLabel.getText();
        return labelSauce;
    }

    public String checkFillingLabel() {
        String labelFilling = fillingLabel.getText();
        return labelFilling;
    }
}
