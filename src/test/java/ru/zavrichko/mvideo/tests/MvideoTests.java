package ru.zavrichko.mvideo.tests;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zavrichko.mvideo.helpers.DriverUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MvideoTests extends TestBase {
    @Test
    @Description("Проверка поиска")
    @DisplayName("Проверка поиска")
    void mvideoSearchVisibleTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("ролики");
            $(".input__field").pressEnter();
        });

        step("Проверка отображения страницы поиска", () -> {
            $(".layout__content").shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Проверка ошибок в консоле")
    @DisplayName("Проверка ошибок в консоле")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://mvideo.ru'", () ->
                open("https://mvideo.ru"));

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
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("ролики");
            $(".input__field").pressEnter();
        });

        step("Проверка количества найденного товара", () -> {
            $(".layout__content").shouldHave(text("Найдено 22 товара"));
        });
    }

    @Test
    @Description("Проверка раздела Доступное качество")
    @DisplayName("Проверка раздела Доступное качество")
    void mvideoLinkQualityTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $x("//a[text()='Доступное качество']").click();
        });

        step("Проверка текста", () -> {
            $(".bp__hero-h").shouldHave(text("Здесь собраны товары по лучшим ценам!"));
        });
    }

    @Test
    @Description("Проверка брендов")
    @DisplayName("Проверка брендов")
    void mvideoBrandTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $x("//a[text()='Доступное качество']").click();
            $x("//a[@href='/promo/dom-mark188276420']").click();
        });

        step("Проверка списка брендов", () -> {
            $("#-brand-section").shouldHave(text("Tefal"));
            $("#-brand-section").shouldHave(text("Philips"));
            $("#-brand-section").shouldHave(text("Rowenta"));
        });
    }

    @Test
    @Description("Проверка наличия фильтра")
    @DisplayName("Проверка наличия фильтра")
    void mvideoFilterTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("телевизор");
            $(".input__field").pressEnter();
        });

        step("Проверка фильтра", () -> {
            $(".dropdown__title").shouldHave(text("Сначала популярные"));
        });
    }

    @Test
    @Description("Проверка невалидного запроса")
    @DisplayName("Проверка невалидного запроса")
    void mvideoEmptySearchTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("авпвапавпвапавп");
            $(".input__field").pressEnter();
        });

        step("Проверка ошибки", () -> {
            $(".empty-products__header").shouldHave(text("По вашему запросу ничего не найдено"));
        });
    }

    @Test
    @Description("Проверка скрипта")
    @DisplayName("Проверка скрипта")
    void mvideoErrorTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("<script>allert</script>");
            $(".input__field").pressEnter();
        });

        step("Проверка ошибки", () -> {
            $(".empty-products-error__header").shouldHave(text("Ошибка"));
            $(".empty-products-error__text").shouldHave(text("Извините, не удалось обработать ваш запрос."));

        });
    }

    @Test
    @Description("Проверка поиска большого значения")
    @DisplayName("Проверка поиска большого значения")
    void mvideoImageErrorTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
            $(".input__field").pressEnter();
        });

        step("Проверка отображения картинки", () -> {
            $(".empty-products__image").shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Проверка смешанного запроса")
    @DisplayName("Проверка смешанного запроса")
    void mvideoNoValidSearchTests() {
        step("Открываем сайт 'https://mvideo.ru'", () -> {
            open("https://mvideo.ru");
        });

        step("Вводим в поиске значение", () -> {
            $(".input__field").click();
            $(".input__field").sendKeys("мвидео-топ");
            $(".input__field").pressEnter();
        });

        step("Проверка количества найденного товара", () -> {
            $(".layout__content").shouldHave(text("Найдено 2 товара"));
        });
    }

}