package guru.qa.lesson6;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.TestBase;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureTestWithListener extends TestBase {
    SelenideElement pageTitle = $x("//h1[text()=' Where the world builds software ']"),
            searchInput = $(".header-search-input"),
            pageTop = $("div#repository-container-header"),
            issuesTab = $(partialLinkText("Issues")),
            pageTopOnSearchPage = $x("//main//input[@aria-label='Search GitHub']"),
            allureExampeleLink = $(linkText("eroshenkoam/allure-example")),
            pageTab = $("a#issues-tab"),
            issueLink = $("div a#issue_68_link");

    private static final String LINK = "https://github.com",
            REPOSITORY = "eroshenkoam/allure-example",
            ISSUE_NAME = "Listeners NamedBy";

    @Test
    @AllureId("7766")
    @Owner("Julia")
    @DisplayName("Check issue name")
    @Feature("GitHub issues have names")
    @Story("GitHub Listener")
    void checkIssueName() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(LINK);
        pageTitle.shouldHave(text("Where the world builds software"));
        searchInput.sendKeys(REPOSITORY);
        searchInput.submit();
        pageTopOnSearchPage.shouldHave(value(REPOSITORY));
        allureExampeleLink.click();
        pageTop.shouldHave(text("allure-example"));
        issuesTab.click();
        pageTab.shouldHave(cssClass("selected"));
        issueLink.shouldHave(text(ISSUE_NAME)).shouldBe(visible);
    }
}