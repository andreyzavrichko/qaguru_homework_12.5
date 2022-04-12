package ru.zavrichko.mvideo.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zavrichko.mvideo.TestBase;
import ru.zavrichko.mvideo.helpers.DriverUtils;
import ru.zavrichko.mvideo.pages.SearchPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTests extends TestBase {
    SearchPage searchPage = new SearchPage();

    @Test
    @Description("Проверка поиска")
    @DisplayName("Проверка поиска")
    void searchVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () -> searchPage.searchInput("ролики"));
        step("Проверка отображения страницы поиска", () -> searchPage.checkResults());
    }

    @Test
    @Description("Проверка ошибок в консоле")
    @DisplayName("Проверка ошибок в консоле")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Проверка отображения количества товаров")
    @DisplayName("Проверка отображения количества товаров")
    void searchCountTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () -> searchPage.searchInput("ролики"));
        step("Проверка количества найденного товара", () -> searchPage.checkResultsCount("Найдено 5 товаров"));
    }

    @Test
    @Description("Проверка раздела Доступное качество")
    @DisplayName("Проверка раздела Доступное качество")
    void linkQualityTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () -> searchPage.clickSearchLink());
        step("Проверка текста", () -> searchPage.checkResultsTextValue("Здесь собраны товары по лучшим ценам!"));
    }

    @Test
    @Description("Проверка брендов")
    @DisplayName("Проверка брендов")
    void brandTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () -> {
            searchPage.clickSearchLink();
            searchPage.clickSearchPromo();
        });
        step("Проверка списка брендов", () -> {
            searchPage.checkResultsBrand("Tefal");
            searchPage.checkResultsBrand("Philips");
            searchPage.checkResultsBrand("Rowenta");
        });
    }

    @Test
    @Description("Проверка наличия фильтра")
    @DisplayName("Проверка наличия фильтра")
    void filterTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () ->
            searchPage.searchInput("телевизор"));
        step("Проверка фильтра", () ->
            searchPage.checkResultsDropdown("Сначала популярные"));
    }

    @Test
    @Description("Проверка невалидного запроса")
    @DisplayName("Проверка невалидного запроса")
    void emptySearchTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () ->
            searchPage.searchInput("авпвапавпвапавп"));
        step("Проверка ошибки", () ->
            searchPage.checkResultsEmpty("По вашему запросу ничего не найдено"));
    }

    @Test
    @Description("Проверка скрипта")
    @DisplayName("Проверка скрипта")
    void errorTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () ->
            searchPage.searchInput("<script>allert</script>"));
        step("Проверка ошибки", () -> {
            searchPage.checkResultsHeader("Ошибка");
            searchPage.checkResultsText("Извините, не удалось обработать ваш запрос.");
        });
    }

    @Test
    @Description("Проверка поиска большого значения")
    @DisplayName("Проверка поиска большого значения")
    void imageErrorTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () ->
            searchPage.searchInput("55555555555555555555555555555555555555555" +
                    "555555555555555555555555555555555555555555555555555555555"));
        step("Проверка отображения картинки", () ->
            searchPage.checkResultsImage());
    }

    @Test
    @Description("Проверка смешанного запроса")
    @DisplayName("Проверка смешанного запроса")
    void noValidSearchTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Вводим в поиске значение", () ->
            searchPage.searchInput("мвидео-топ"));
        step("Проверка количества найденного товара", () ->
            searchPage.checkResultsLayout("Найдено 2 товара"));
    }
}