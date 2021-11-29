package guru.qa.lesson8;

import guru.qa.TestBase;
import guru.qa.dataProvider.Dreams;
import guru.qa.pages.DreamBookPage;
import guru.qa.pages.gitHub.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests extends TestBase {
    GitHubPage gitHubPage = new GitHubPage();
    GitHubSearchResultPage gitHubSearchResultPage = new GitHubSearchResultPage();
    DreamBookPage dreamBookPage = new DreamBookPage();

    @Tag("minor")
    @DisplayName("Search in github returns repository link")
    @ParameterizedTest
    @ValueSource(strings = {"Dydkina/qaGuru", "eroshenkoam/allure-example"})
    void checkGitHubSearchResults(String valueForSearch) {
        gitHubPage.openGitHub()
                .setValueInSearchInput(valueForSearch)
                .clickSearch();

        gitHubSearchResultPage.searchResultPageContainsSerchedValue(valueForSearch);
    }

    @Tag("minor")
    @DisplayName("Search in dream book returns searched value")
    @ParameterizedTest(name = "dream=''{0}''")
    @EnumSource(value = Dreams.class)
    void checkDreamBookSearchResults(Dreams dream) throws InterruptedException {
        dreamBookPage.openDdreamBook()
                .setValueInSearchInputAndClickFirstResult(dream)
                .searchResultContainsSearchedValue(dream);
    }

    @Tag("minor")
    @DisplayName("Search in dream book CSV values returns searched value")
    @ParameterizedTest(name = "dream=''{0}''")
    @CsvFileSource(resources = "/dreams.csv",
    delimiter = ';')
    void checkDreamBookSearchResultsWithCSVValues(String dream) throws InterruptedException {
        dreamBookPage.openDdreamBook()
                .setValueInSearchInputAndClickFirstResult(dream)
                .searchResultContainsSearchedValue(dream);
    }
}
