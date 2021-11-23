package guru.qa.lesson7;

import guru.qa.TestBase;
import guru.qa.pages.filesSites.BlackSwanMainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BlackSwanMenuTests extends TestBase {

    BlackSwanMainPage blackSwanMainPage = new BlackSwanMainPage();

    @Test
    @Owner("Julia")
    @DisplayName("Menu has vegetables")
    @Feature("Black swan main add menu PDF")
    @Story("Black swan menu")
    void downloadMenuAndCheckVegetableItemInIt() throws IOException {
        blackSwanMainPage.openBlackSwanMainPage().
                downloadedFileHave();
    }

    @Test
    @Owner("Julia")
    @DisplayName("Menu has vegetables")
    @Feature("Black swan main add menu PDF")
    @Story("Black swan menu")
    void downloadCSVAndCheck() throws IOException {
        blackSwanMainPage.openBlackSwanMainPage().
                downloadedFileHave();
    }
}