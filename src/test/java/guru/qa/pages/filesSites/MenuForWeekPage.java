package guru.qa.pages.filesSites;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.xlstest.XLS.containsRow;
import static org.hamcrest.MatcherAssert.assertThat;

public class MenuForWeekPage {
    SelenideElement pageTitle = $(".site-main h1"),
            downloadMenuButton = $("a.g-button");

    @Step("Open vkusnayapo4ta menu for week")
    public MenuForWeekPage openMenuPage() {
        open("https://vkusnayapo4ta.ru/menyu-na-nedelyu-v-formate-excel-1");
        pageTitle.shouldHave(text("Меню на неделю в формате Excel"));
        return this;
    }

    @Step("Downloaded XLS title 'Меню  с 02 по 06.11.2019 года'")
    public void XLSContains() throws IOException {
        XLS parsedXls = new XLS(downloadMenuButton.download());

        assertThat(parsedXls, containsRow("Меню  с 02 по 06.11.2019 года"));
    }
}
