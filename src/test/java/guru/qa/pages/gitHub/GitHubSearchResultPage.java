package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GitHubSearchResultPage {
    SelenideElement pageTop = $x("//main//input[@aria-label='Search GitHub']"),
            allureExampeleLink = $(linkText("eroshenkoam/allure-example"));

    @Step("Click on allure exampele link")
    public GitHubAllureExamplePage clickOnAllureExampeleLink() {
        pageTop.shouldHave(value("eroshenkoam/allure-example"));
        allureExampeleLink.click();
        return new GitHubAllureExamplePage();
    }
}
