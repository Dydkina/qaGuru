package guru.qa.lesson5;

import guru.qa.TestBase;
import guru.qa.pages.demoqa.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTestWithFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
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
                .fillAddres()
                .selectStateAndCity()
                .submitClick()
                .compareValuesWithWeb();
    }

}
