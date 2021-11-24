package guru.qa.lesson7;

import guru.qa.TestBase;
import guru.qa.pages.filesSites.MenuForWeekPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class XLSFileTests extends TestBase {
    MenuForWeekPage menuForWeekPage = new MenuForWeekPage();

    @Test
    @Owner("Julia")
    @DisplayName("Downloaded CSV is equal to username.csvs")
    @Feature("XLS example should be displayed on the sites")
    @Story("XLS menu on the site")
    void downloadCSVExampleAndCompareValuesWithUsernameCSVs() throws IOException {
        menuForWeekPage.openMenuPage().
                downloadedXlsContainsTitle();
    }
}