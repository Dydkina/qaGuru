package guru.qa.lesson7;

import com.opencsv.exceptions.CsvException;
import guru.qa.TestBase;
import guru.qa.pages.filesSites.CSVFileExamplesPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CSVFileTests extends TestBase {

    CSVFileExamplesPage csvFileExamplesPage = new CSVFileExamplesPage();

    @Test
    @Owner("Julia")
    @DisplayName("Downloaded CSV is equal to username.csv")
    @Feature("CSV example should be displayed on the site")
    @Story("CSV examples on the site")
    void downloadCSVExampleAndCompareValuesWithUsernameCSV() throws IOException, CsvException {
        csvFileExamplesPage.openCSVFileExamplesPage().
                compareCSVs();
    }
}