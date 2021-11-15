package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPage {
    SelenideElement pageTitle = $x("//h1[text()=' Where the world builds software ']"),
            searchInput = $(".header-search-input");

    @Step("Open gitHub")
    public GitHubPage openGitHub() {
        open("https://github.com");
        pageTitle.shouldHave(text("Where the world builds software"));
        return this;
    }

    @Step("Open eroshenkoam/allure-example in search input")
    public GitHubPage setValueInSearchInput() {
        searchInput.sendKeys("eroshenkoam/allure-example");
        return this;
    }

    @Step("Click to search")
    public GitHubSearchResultPage clickSearch() {
        searchInput.submit();
        return new GitHubSearchResultPage();
    }
}
