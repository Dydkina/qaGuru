package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SubmitForm {
    SelenideElement submitFormWindow = $(".fade.modal.show"),
            submitFormTitle = $(".modal-title");

    protected List<String> submitFormValues() {
        List<String> submitTableList = $$x("//tbody/tr/td[2]").texts();

        submitFormWindow.shouldBe(Condition.visible);
        submitFormTitle.shouldHave(text("Thanks for submitting the form"));

        return submitTableList;
    }
}