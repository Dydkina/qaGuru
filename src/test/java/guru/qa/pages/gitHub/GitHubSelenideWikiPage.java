package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubSelenideWikiPage {

    SelenideElement wikiPageTitle = $("#wiki-body h1"),
            morePagesButton = $(".wiki-more-pages-link button"),
            softAssertionsPageLink = $("div #wiki-pages-box").$(byText("SoftAssertions"));

    public void clickShowMorePages() {
        wikiPageTitle.shouldHave(text("Welcome to the selenide wiki!"));
        morePagesButton.click();
    }

    public GitHubSelenideSoftAssertionsPage openSoftAssertionsPage() {
        softAssertionsPageLink.click();
        return new GitHubSelenideSoftAssertionsPage();
    }
}
