package guru.qa.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteWebDriver")
    String remoteWebDriver();

    @Key("remoteUrl")
    URL getRemoteUrl();

    @Key("browserVersion")
    @DefaultValue("95")
    String getBrowserVersion();
}
