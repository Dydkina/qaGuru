package guru.qa.lesson6;

import guru.qa.pages.gitHub.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureTestWithStepAnotation {
    GitHubPage gitHubPage = new GitHubPage();
    GitHubSearchResultPage gitHubSearchResultPage = new GitHubSearchResultPage();
    GitHubAllureExamplePage gitHubAllureExamplePage = new GitHubAllureExamplePage();
    GitHubAllureIssuesPage gitHubAllureIssuesPage = new GitHubAllureIssuesPage();

    @Test
    @Owner("Julia")
    @DisplayName("Check issue name")
    @Feature("GitHub issues have names")
    @Story("GitHub")
    void checkIssueName() {
        gitHubPage.openGitHub()
                .setValueInSearchInput()
                .clickSearch();
        gitHubSearchResultPage.clickOnAllureExampeleLink();
        gitHubAllureExamplePage.clikOnIssuesLink();
        gitHubAllureIssuesPage.checkIssueName();
    }
}