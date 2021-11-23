package guru.qa.pages.filesSites;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BlackSwanMainPage {
    SelenideElement address = $(".adr"),
            menuDownloadLink = $(".menu a");

    @Step("Open Black swan main")
    public BlackSwanMainPage openBlackSwanMainPage() {
        open("http://bspubshop.ru");
        address.shouldHave(text("Москва, Солянка, 1/2"));
        return this;
    }

    @Step("Downloaded menu has vegetables")
    public void downloadedFileHave() throws IOException {
        PDF menuPDF = new PDF(menuDownloadLink.download());

        Assertions.assertTrue(menuPDF.text.contains("Овощи из печи"), menuPDF.text);
    }
}
