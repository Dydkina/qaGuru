package guru.qa.pages.gitHub;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubAllureIssuesPage {
    SelenideElement pageTab = $("a#issues-tab"),
            issueLink = $("div a#issue_68_link");

    @Step("Issue number has text 'Listeners NamedBy'")
    public GitHubAllureIssuesPage checkIssueName() {
        pageTab.shouldHave(cssClass("selected"));
        issueLink.shouldHave(text("Listeners NamedBy")).shouldBe(visible);
        addScreenshot();
        return this;
    }

    private void addScreenshot() {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
