package guru.qa;

import com.codeborne.selenide.Configuration;
import config.CredentialsConfig;
import guru.qa.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);

        Configuration.remote = format("https://%s:%s@%s",
                credentials.login(),
                credentials.password(),
                credentials.url());

        DesiredCapabilities capabilities = new DesiredCapabilities();
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