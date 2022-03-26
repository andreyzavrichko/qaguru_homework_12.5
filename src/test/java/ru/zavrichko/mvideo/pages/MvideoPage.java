package ru.zavrichko.mvideo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MvideoPage {
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



    public MvideoPage typeInput (String value) {
        searchInput.click();
        searchInput.setValue(value);
        searchInput.pressEnter();

        return this;
    }

    public MvideoPage typeResults () {
        resultsValue.shouldBe(Condition.visible);

        return this;
    }

    public MvideoPage typeResultsCount (String value) {
        resultsValueCount.shouldHave(text(value));

        return this;
    }

    public MvideoPage typeSearchLink () {
        searchLink.click();

        return this;
    }

    public MvideoPage typeSearchPromo () {
        searchPromo.click();

        return this;
    }

    public MvideoPage typeResultsTextValue (String value) {
        resultsTextValue.shouldHave(text(value));

        return this;
    }

    public MvideoPage typeResultsBrand (String value) {
        resultsBrand.shouldHave(text(value));

        return this;
    }
    public MvideoPage typeResultsDropdown (String value) {
        resultsDropdown.shouldHave(text(value));

        return this;
    }
    public MvideoPage typeResultsEmpty (String value) {
        resultsEmpty.shouldHave(text(value));

        return this;
    }
    public MvideoPage typeResultsHeader (String value) {
        resultsHeader.shouldHave(text(value));

        return this;
    }
    public MvideoPage typeResultsText (String value) {
        resultsText.shouldHave(text(value));

        return this;
    }
    public MvideoPage typeResultsImage () {
        resultsImage.shouldBe(Condition.visible);

        return this;
    }
    public MvideoPage typeResultsLayout (String value) {
        resultsLayout.shouldHave(text(value));

        return this;
    }
}
