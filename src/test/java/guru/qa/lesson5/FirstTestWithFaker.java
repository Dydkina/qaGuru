package guru.qa.lesson5;

import guru.qa.TestBase;
import guru.qa.pages.demoqa.RegistrationPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FirstTestWithFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @AllureId("7754")
    @Tag("Critical")
    @DisplayName("Check automation form")
    @Owner("Julia")
    void CheckForm() {
        registrationPage.openAutomationPracticeForm()
                .fillName()
                .fillEmail()
                .chooseGender()
                .fillPhoneNumber()
                .setDateOfBirth()
                .setSubject()
                .chooseHobby()
                .uploadPicture()
                .fillAddress()
                .selectStateAndCity()
                .submitClick()
                .compareValuesWithWeb();
    }
}
