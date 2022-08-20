package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.actualAdrress;
import static tests.TestData.pickupPoints;

public class MainPage {
    private final SelenideElement mainSearchField = $("#searchInput");
    private final SelenideElement sellButton = $(".simple-menu__link--sell-on-wb");
    private final SelenideElement employmentButton = $(".simple-menu__link--employment");
    private final SelenideElement chatBot = $(".smm-fixed__toggle");
    private final SelenideElement chatText = $(".message__text");
    private final SelenideElement location = $(".j-geocity-link");
    private final SelenideElement delivery = $(".popup__content-left--open");
    private final SelenideElement searchOfAdrress = $(".popup__content").$(".ymaps-2-1-79-searchbox-input__input");
    private final SelenideElement result = $("#pooList");

    public void searchProduct(String productName) {
        mainSearchField.setValue(productName).pressEnter();
        sleep(3000);
    }

    public void checkSellButton() {
        sellButton.shouldBe(visible).click();
    }

    public void getNumberOfWindows() {
        Assertions.assertEquals(
                2,
                WebDriverRunner.getWebDriver().getWindowHandles().size()
        );
    }

    public void switchTab() {
        switchTo().window(1);
    }

    public void checkEmploymentButton() {
        employmentButton.shouldBe(visible).click();
    }

    public void checkChatBot() {
        chatBot.shouldBe(visible).click();
    }

    public void checkChatText() {
        String text = "Я Лина - виртуальный помощник службы поддержки. Если у Вас возник вопрос - задайте его в этом чате, и я с удовольствием отвечу на него.";
        chatText.shouldHave(text(text));
    }
    public void deliveryWindow(){
        location.click();
        delivery.shouldBe(visible);
    }
    public void searchAdrress(){
        searchOfAdrress.click();
        searchOfAdrress.setValue(actualAdrress).pressEnter();
    }
    public void checkResultAdrress(){
        result.shouldHave(text(pickupPoints));
    }
}
