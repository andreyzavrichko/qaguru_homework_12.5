package ru.zavrichko.mvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    SelenideElement
            searchInput = $(".input__field"),
            searchLink = $x("//a[text()='Доступное качество']"),
            searchPromo = $x("//a[@href='/promo/dom-mark188276420']"),

    resultsValue = $(".layout__content"),
            resultsValueCount = $(".layout__content"),
            resultsBrand = $("#-brand-section"),
            resultsDropdown = $(".dropdown__title"),
            resultsEmpty = $(".empty-products__header"),
            resultsHeader = $(".empty-products-error__header"),
            resultsText = $(".empty-products-error__text"),
            resultsImage = $(".empty-products__image"),
            resultsLayout = $(".layout__content"),
            resultsTextValue = $(".bp__hero-h");


    public SearchPage searchInput(String value) {
        searchInput.click();
        searchInput.setValue(value);
        searchInput.pressEnter();

        return this;
    }

    public SearchPage checkResults() {
        resultsValue.shouldBe(Condition.visible);

        return this;
    }

    public SearchPage checkResultsCount(String value) {
        resultsValueCount.shouldHave(text(value));

        return this;
    }

    public SearchPage clickSearchLink() {
        searchLink.click();

        return this;
    }

    public SearchPage clickSearchPromo() {
        searchPromo.click();

        return this;
    }

    public SearchPage checkResultsTextValue(String value) {
        resultsTextValue.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsBrand(String value) {
        resultsBrand.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsDropdown(String value) {
        resultsDropdown.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsEmpty(String value) {
        resultsEmpty.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsHeader(String value) {
        resultsHeader.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsText(String value) {
        resultsText.shouldHave(text(value));

        return this;
    }

    public SearchPage checkResultsImage() {
        resultsImage.shouldBe(Condition.visible);

        return this;
    }

    public SearchPage checkResultsLayout(String value) {
        resultsLayout.shouldHave(text(value));

        return this;
    }
}
