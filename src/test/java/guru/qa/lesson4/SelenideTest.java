package guru.qa.lesson4;

import guru.qa.pages.gitHub.GitHubSelenidePage;
import guru.qa.pages.gitHub.GitHubSelenideSoftAssertionsPage;
import guru.qa.pages.gitHub.GitHubSelenideWikiPage;
import org.junit.jupiter.api.Test;

public class SelenideTest {
    GitHubSelenidePage gitHubPage = new GitHubSelenidePage();
    GitHubSelenideWikiPage gitHubWikiPage = new GitHubSelenideWikiPage();
    GitHubSelenideSoftAssertionsPage gitHubSoftAssertionsPage = new GitHubSelenideSoftAssertionsPage();

    @Test
    void checkVisibleJunit5CodeExample() {
        gitHubPage.openGitHubSelenide();
        gitHubPage.openWikiPage();
        gitHubWikiPage.clickShowMorePages();
        gitHubWikiPage.openSoftAssertionsPage();
        gitHubSoftAssertionsPage.checkJunitExampleBlockVisible();
    }
}