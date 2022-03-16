package guru.qa.lesson11;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestWithProperty {

    @Test
    @AllureId("7762")
    @Tag("properties")
    void propertyTestFirst() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }

    @Test
    @AllureId("7759")
    @Tag("properties")
    void propertyTestSecond() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}
