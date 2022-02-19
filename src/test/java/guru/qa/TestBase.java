package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.config.CredentialsConfig;
import guru.qa.config.DriverSettings;
import guru.qa.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();

        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);
        Configuration.remote = format("https://%s:%s@%s",
                credentials.login(),
                credentials.password(),
                credentials.url());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}