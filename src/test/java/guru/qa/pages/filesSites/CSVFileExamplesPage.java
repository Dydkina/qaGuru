package guru.qa.pages.filesSites;

import com.codeborne.selenide.SelenideElement;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CSVFileExamplesPage {
    SelenideElement pageTitle = $(".article-header h1"),
            usernameOnboardingDownloadLink = $x("//a[contains(text(), 'Minimum Data Set for Username Onboarding')]");

    @Step("Open CSV file examples")
    public CSVFileExamplesPage openCSVFileExamplesPage() {
        open("https://support.staffbase.com/hc/en-us/articles/360007108391-CSV-File-Examples");
        pageTitle.shouldHave(text("CSV File Examples"));
        return this;
    }

    @Step("Downloaded CSV is equal 'username.csv'")
    public void compareCSVs() throws IOException, CsvException {
        ArrayList downloadedUsernameCSVList = new ArrayList();

        try (CSVReader csvReader = new CSVReader(new FileReader(usernameOnboardingDownloadLink.download()))){
            List<String[]> downloadedUsernameCSV = csvReader.readAll();
            downloadedUsernameCSV.forEach(x -> downloadedUsernameCSVList.add(Arrays.toString(x)));
        };

        FileReader usernameReader = new FileReader(getClass().getClassLoader().getResource("username.csv").getFile());

        ArrayList usernameStringsList = new ArrayList();

        try (CSVReader usernameCsvReader = new CSVReader(usernameReader)) {
            List<String[]> usernameStrings = usernameCsvReader.readAll();
            usernameStrings.forEach(x -> usernameStringsList.add(Arrays.toString(x)));
        }

        Assertions.assertEquals(usernameStringsList, downloadedUsernameCSVList);
    }
}
