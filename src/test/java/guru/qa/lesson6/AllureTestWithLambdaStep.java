package guru.qa.lesson6;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureTestWithLambdaStep {
    SelenideElement pageTitle = $x("//h1[text()=' Where the world builds software ']"),
            searchInput = $(".header-search-input"),
            pageTop = $x("//div[@id='repository-container-header']"),
            issuesTab = $(partialLinkText("Issues")),
            pageTopOnSearchPage = $x("//main//input[@aria-label='Search GitHub']"),
            allureExampeleLink = $(linkText("eroshenkoam/allure-example")),
            pageTab = $x("//a[@id='issues-tab']"),
            issueLink = $x("//div//a[@id='issue_68_link']");

    private static final String LINK = "https://github.com",
            REPOSITORY = "eroshenkoam/allure-example",
            ISSUE_NAME = "Listeners NamedBy";

    @Test
    @Owner("Julia")
    @DisplayName("Check issue name")
    @Feature("GitHub issues have names")
    @Story("GitHub Lambda Step")
    @Severity(SeverityLevel.MINOR)
    void checkIssueNameLambda() {
        step("Open " + LINK, () -> {
            open(LINK);
            pageTitle.shouldHave(text("Where the world builds software"));
        });
        step("Open " + REPOSITORY + " in search input", () -> {
            searchInput.sendKeys(REPOSITORY);
            searchInput.submit();
        });
        step("Click on allure example link", () -> {
            pageTopOnSearchPage.shouldHave(value(REPOSITORY));
            allureExampeleLink.click();
        });
        step("Click on issues tab", () -> {
            pageTop.shouldHave(text("allure-example"));
            issuesTab.click();
        });
        step("Issue number has text '" + ISSUE_NAME + "'", () -> {
            pageTab.shouldHave(cssClass("selected"));
            issueLink.shouldHave(text(ISSUE_NAME)).shouldBe(visible);
        });
    }
}