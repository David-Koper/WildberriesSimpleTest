package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class SearchResultsPage {

    public void addToBasket(String productName) throws InterruptedException {

        $$(".product-card__brand").filterBy(text(productName)).first().hover();
        sleep(1000);
        //$(".btn-main").click();
        String toBasket = "В корзину";
        $(byLinkText(toBasket)).click();
        sleep(1000);
    }

    public void moveToBasket() {
        String basket = "Корзина";
        $(byText(basket)).click();
    }
}
