package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.browser = System.getProperties().getProperty("BROWSER");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setVersion(System.getProperties().getProperty("VERSION"));
        capabilities.setCapability("name", "Juli S. tests");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;}

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}