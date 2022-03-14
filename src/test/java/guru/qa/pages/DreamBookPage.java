package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DreamBookPage {
    SelenideElement pageTitle = $("div.up"),
            searchInput = $("#acfield"),
            resultPageTitle = $$(".sw").first();

        ElementsCollection searchButton = $$(".acResults li");

        @Step("Open sonnik page")
        public DreamBookPage openDdreamBook() {
        open("https://www.sonnik-online.net/");
        pageTitle.shouldHave(text("Сонник, толкование снов."));
        return this;
    }

    @Step("Search dream")
    public DreamBookPage setValueInSearchInputAndClickFirstResult(Enum searchValue) throws InterruptedException {
        searchInput.sendKeys(searchValue.toString());
        Thread.sleep(1000);
        searchButton.first().shouldHave(text(String.valueOf(searchValue))).click();

        return this;
    }

    @Step("Search dream")
    public DreamBookPage setValueInSearchInputAndClickFirstResult(String searchValue) throws InterruptedException {
        searchInput.sendKeys(searchValue);
        Thread.sleep(1000);
        searchButton.first().shouldHave(text(searchValue)).click();

        return this;
    }

    @Step("Check search result")
    public void searchResultContainsSearchedValue(String searchValue){
        resultPageTitle.shouldHave(text(searchValue));
    }

    @Step("Check search result")
    public void searchResultContainsSearchedValue(Enum searchValue){
        resultPageTitle.shouldHave(text(String.valueOf(searchValue)));
    }
}
