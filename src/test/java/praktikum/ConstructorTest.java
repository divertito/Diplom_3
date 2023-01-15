package praktikum;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    Constructor constructor;

    public ConstructorTest() {
    }

    @Before
    public void setUp() {
        this.constructor = open("https://stellarburgers.nomoreparties.site", Constructor.class);
    }

    @Test
    @DisplayName("Конструктор: переходы к разделам")
    public void moveBetweenTabsTest() {
        this.constructor.clickSauseTab();
        this.constructor.sauceLabel.shouldBe(new Condition[]{Condition.visible});
        Assert.assertEquals("Tab Sauce was not clicked", "Соусы", this.constructor.checkSauceLabel());
        this.constructor.clickFillingTab();
        this.constructor.fillingLabel.shouldBe(new Condition[]{Condition.visible});
        Assert.assertEquals("Tab Filling was not clicked", "Начинки", this.constructor.checkFillingLabel());
        this.constructor.clickBunsTab();
        this.constructor.bunsLabel.shouldBe(new Condition[]{Condition.visible});
        Assert.assertEquals("Tab Buns was not clicked", "Булки", this.constructor.checkBunsLabel());
    }

    @Test
    @DisplayName("Переход в личный кабинет и возврат в конструктор")
    public void switchToConstructorTest() {
        this.constructor.clickAccountButton();
        Assert.assertEquals("Account was not opened", "Вход", this.constructor.getSignUpInPageHeader());
        this.constructor.clickBurgerConstructorButton();
        Assert.assertEquals("Constructor was not opened", "Соберите бургер", this.constructor.getMainPageHeader());
    }

    @Test
    @DisplayName("Переход в личный кабинет и возврат в конструктор по клику на логотип")
    public void switchToConstructorByLogoClickTest() {
        this.constructor.clickAccountButton();
        Assert.assertEquals("Account was not opened", "Вход", this.constructor.getSignUpInPageHeader());
        this.constructor.clickPageLogo();
        Assert.assertEquals("Constructor was not opened", "Соберите бургер", this.constructor.getMainPageHeader());
    }
}
