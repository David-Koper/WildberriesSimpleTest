package tests;

import helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import helpers.DriverUtils;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.TestData.*;
import static tests.TestData.productName;

public class GeneratedTests extends TestBase {

    @Test
    @DisplayName("Проверка отсутствия ошибок в журнале консоли главной страницы")
    void consoleShouldNotHaveErrorsTest() {
        step("Проверка отсутствия ошибок ошибок 'SEVERE' в логах консоли", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            assertThat(consoleLogs).doesNotContain("SEVERE");
        });
    }

    @Test
    @DisplayName("Проверка функциональности корзины")
    void basketTest() {
        step("Поиск товара", () -> {
            mainPage.searchProduct(productName);
        });

        step("Добавление товара в корзину", () -> {
            searchResultsPage.addToBasket(productName);
        });

        step("Переход в корзину", () -> {
            searchResultsPage.moveToBasket();
        });

        step("Проверка корзины", () -> {
            basketPage.checkProduct(productName);
        });

        step("Очистка корзины", () -> {
            basketPage.clearBasket();
        });

        step("Проверка пустой корзины", () -> {
            basketPage.checkEmptyBasket();
        });
    }

    @Test
    @DisplayName("Проверка действия кнопки 'Продавайте на Wildberries'")
    void sellButtonTest() {
        step("Проверка видимости кнопки и её нажатие", () -> {
            mainPage.checkSellButton();
        });

        step("Проверка открытия новой вкладки", () -> {
            mainPage.getNumberOfWindows();
        });

        step("Переход на новую вкладку", () -> {
            mainPage.switchTab();
        });
    }

    @Test
    @DisplayName("Проверка наличия кнопки 'Работа в Wildberries'")
    void employmentButtonTest() {
        step("Проверка видимости кнопки и её нажатие", () -> {
            mainPage.checkEmploymentButton();
        });
    }

    @Test
    @DisplayName("Проверка доступности чат-бота")
    void chatBotTest() {
        step("Проверка видимости кнопки вызова чат-бота её нажатие", () -> {
            mainPage.checkChatBot();
        });

        step("Проверка текста приветствия чат-бота", () -> {
            mainPage.checkChatText();
        });
    }
    @Test
    @DisplayName("Проверка поиска пункта выдачи")
    void searchPickupPoints() {
        step("Проверка видимости окна поиска пункта выдачи", () -> {
            mainPage.deliveryWindow();
        });

        step("Ввод актуального домашнего адреса", () -> {
            mainPage.searchAdrress();
        });
        step("Проверка корректного поиска пункта выдачи", () -> {
            mainPage.checkResultAdrress();
        });
    }
}

