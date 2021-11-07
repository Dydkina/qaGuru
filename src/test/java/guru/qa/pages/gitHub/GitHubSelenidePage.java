package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSelenidePage {

    SelenideElement pageTitle = $("h1 [itemprop='name']"),
            wikiTab = $("#wiki-tab");

    public void openGitHubSelenide() {
        open("https://github.com/selenide/selenide");
        pageTitle.shouldHave(text("selenide"));
    }

    public GitHubSelenideWikiPage openWikiPage() {
        wikiTab.click();
        return new GitHubSelenideWikiPage();
    }
}
