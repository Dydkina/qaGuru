package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideSoftAssertionsPage {

    SelenideElement pageTitle = $("#wiki-wrapper"),
            junitExampleBlock = $x("//*[@id='wiki-body']//li[contains(text(),'Using JUnit5')]");

    public void checkJunitExampleBlockVisible() {
        pageTitle.shouldHave(text("SoftAssertions"));
        junitExampleBlock.scrollIntoView(true);
        junitExampleBlock.shouldBe(visible).shouldHave(text("Using JUnit5 extend test class:"));
    }
}