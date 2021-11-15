package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.partialLinkText;

public class GitHubAllureExamplePage {
    SelenideElement pageTop = $x("//div[@id='repository-container-header']"),
           issuesTab = $(partialLinkText("Issues"));

    @Step("Click on issues tab")
    public GitHubAllureIssuesPage clikOnIssuesLink() {
        pageTop.shouldHave(text("allure-example"));
        issuesTab.click();
        return new GitHubAllureIssuesPage();
    }
}
