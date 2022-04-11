package ru.zavrichko.mvideo.tests;


import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zavrichko.mvideo.TestBase;
import ru.zavrichko.mvideo.helpers.DriverUtils;
import ru.zavrichko.mvideo.pages.MvideoPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MvideoTests extends TestBase {
    MvideoPage mvideoPage = new MvideoPage();

    @Test
    @Description("Проверка поиска")
    @DisplayName("Проверка поиска")
    void mvideoSearchVisibleTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("ролики");
        });
        step("Проверка отображения страницы поиска", () ->
                mvideoPage.typeResults()
        );
    }

    @Test
    @Description("Проверка ошибок в консоле")
    @DisplayName("Проверка ошибок в консоле")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Проверка отображения количества товаров")
    @DisplayName("Проверка отображения количества товаров")
    void mvideoSearchCountTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );

        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("ролики");
        });

        step("Проверка количества найденного товара", () -> {
            mvideoPage.typeResultsCount("Найдено 5 товаров");
        });
    }

    @Test
    @Description("Проверка раздела Доступное качество")
    @DisplayName("Проверка раздела Доступное качество")
    void mvideoLinkQualityTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );

        step("Вводим в поиске значение", () -> {
            mvideoPage.typeSearchLink();
        });
        step("Проверка текста", () -> {
            mvideoPage.typeResultsTextValue("Здесь собраны товары по лучшим ценам!");
        });
    }

    @Test
    @Description("Проверка брендов")
    @DisplayName("Проверка брендов")
    void mvideoBrandTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeSearchLink();
            mvideoPage.typeSearchPromo();
        });
        step("Проверка списка брендов", () -> {
            mvideoPage.typeResultsBrand("Tefal");
            mvideoPage.typeResultsBrand("Philips");
            mvideoPage.typeResultsBrand("Rowenta");
        });
    }

    @Test
    @Description("Проверка наличия фильтра")
    @DisplayName("Проверка наличия фильтра")
    void mvideoFilterTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("телевизор");
        });
        step("Проверка фильтра", () -> {
            mvideoPage.typeResultsDropdown("Сначала популярные");
        });
    }

    @Test
    @Description("Проверка невалидного запроса")
    @DisplayName("Проверка невалидного запроса")
    void mvideoEmptySearchTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("авпвапавпвапавп");
        });
        step("Проверка ошибки", () -> {
            mvideoPage.typeResultsEmpty("По вашему запросу ничего не найдено");
        });
    }

    @Test
    @Description("Проверка скрипта")
    @DisplayName("Проверка скрипта")
    void mvideoErrorTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("<script>allert</script>");
        });
        step("Проверка ошибки", () -> {
            mvideoPage.typeResultsHeader("Ошибка");
            mvideoPage.typeResultsText("Извините, не удалось обработать ваш запрос.");
        });
    }

    @Test
    @Description("Проверка поиска большого значения")
    @DisplayName("Проверка поиска большого значения")
    void mvideoImageErrorTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
        });
        step("Проверка отображения картинки", () -> {
            mvideoPage.typeResultsImage();
        });
    }

    @Test
    @Description("Проверка смешанного запроса")
    @DisplayName("Проверка смешанного запроса")
    void mvideoNoValidSearchTests() {
        step("Открываем сайт 'https://mvideo.ru'", () ->
                open(baseUrl)
        );
        step("Вводим в поиске значение", () -> {
            mvideoPage.typeInput("мвидео-топ");
        });
        step("Проверка количества найденного товара", () -> {
            mvideoPage.typeResultsLayout("Найдено 2 товара");
        });
    }
}