package guru.qa;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTestWithFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void CheckForm() {
        open("https://demoqa.com/automation-practice-form");
        
        registrationPage.fillName();
        registrationPage.fillEmail();
        registrationPage.chooseGender();
        registrationPage.fillPhoneNumber();
        registrationPage.setDateOfBirth();
        registrationPage.setSubject();
        registrationPage.chooseHobby();
        registrationPage.uploadPicture();
        registrationPage.fillAddres();
        registrationPage.selectStateAndCity();
        registrationPage.submitClick();

        registrationPage.compareValuesWithWeb();
    }

}
