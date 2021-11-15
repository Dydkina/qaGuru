package guru.qa.pages.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage {
    Faker faker = new Faker(new Locale("eng"));

    SubmitForm submitForm = new SubmitForm();

    String[] date = chooseRandomDate();
    String day = date[0];
    String month_year = date[1];
    String year = date[2];

    String firstNameValue = faker.name().firstName(),
            lastNameValue = faker.name().lastName(),
            emailValue = faker.internet().emailAddress(),
            genderValue = faker.demographic().sex(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dateOfBirthValue = day + " " + month_year + "," + year,
            subjectsValue = "English",
            hobbiesValue = "Reading",
            picValue = "kit.jpg",
            addressValue = faker.address().fullAddress(),
            stateValue = "Haryana",
            cityValue = "Karnal";

    private ArrayList newCustomerValues() {
        ArrayList newCustomerValues = new ArrayList();

        newCustomerValues.addAll(Arrays.asList(firstNameValue + " " + lastNameValue, emailValue, genderValue, phoneNumber,
                dateOfBirthValue, subjectsValue, hobbiesValue, picValue, addressValue, stateValue + " " + cityValue));

        return newCustomerValues;
    }

    SelenideElement firstNameInput = $("#firstName"),
            pageTitle = $(".practice-form-wrapper"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadio = $x("//div[@id='genterWrapper']//*[text()='" + genderValue + "']"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            datepickerYearDropDown = $(".react-datepicker__year-select"),
            datepickerMonthDropDown = $(".react-datepicker__month-select"),
            datepickerDayPicker = $x("//div[text()='" + day + "' and (contains(@aria-label,'" + month_year + "'))]"),
            subjectsContainer = $(".subjects-auto-complete__value-container"),
            subjectsInput = $("#subjectsInput"),
            subjectsDropDown = $(".subjects-auto-complete__menu"),
            hobbyChekbox = $("#hobbiesWrapper"),
            fileUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropDown = $("#state"),
            stateDropDownElement = $x("//div[@id='state']//*[text()='" + stateValue + "']"),
            cityDropDown = $("#city"),
            cityDropDownElement = $x("//div[@id='city']//*[text()='" + cityValue + "']"),
            submitButton = $("#submit");

    @Step("Open automation practice form")
    public RegistrationPage openAutomationPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        pageTitle.shouldHave(Condition.text("Student Registration Form"));
        return this;
    }

    @Step("Fill name field")
    public RegistrationPage fillName() {
        firstNameInput.setValue(firstNameValue);
        lastNameInput.setValue(lastNameValue);
        return this;
    }

    @Step("Fill email field")
    public RegistrationPage fillEmail() {
        userEmailInput.setValue(emailValue);
        return this;
    }

    @Step("Choose gender")
    public RegistrationPage chooseGender() {
        genderRadio.click();
        return this;
    }

    @Step("Fill phone number field")
    public RegistrationPage fillPhoneNumber() {
        userNumber.setValue(phoneNumber);
        return this;
    }

    @Step("Set date of birth")
    public RegistrationPage setDateOfBirth() {
        dateOfBirthInput.click();
        datepickerYearDropDown.selectOption(year);
        datepickerMonthDropDown.selectOption(month_year);
        datepickerDayPicker.click();
        closeDatePicker();
        return this;
    }

    @Step("Set subject")
    public RegistrationPage setSubject() {
        subjectsContainer.click();
        subjectsInput.setValue(subjectsValue);
        subjectsDropDown.$(byText(subjectsValue)).click();
        return this;
    }

    @Step("Choose hobby")
    public RegistrationPage chooseHobby() {
        hobbyChekbox.$((byText(hobbiesValue))).click();
        return this;
    }

    @Step("Upload picture")
    public RegistrationPage uploadPicture() {
        fileUpload.uploadFromClasspath(picValue);
        return this;
    }

    @Step("Fill address field")
    public RegistrationPage fillAddress() {
        addressInput.setValue(addressValue);
        return this;
    }

    @Step("Select state and city")
    public RegistrationPage selectStateAndCity() {
        stateDropDown.scrollIntoView(true);
        stateDropDown.click();
        stateDropDownElement.click();
        cityDropDown.click();
        cityDropDownElement.click();
        return this;
    }

    @Step("Click on 'Submit' button")
    public RegistrationPage submitClick() {
        submitButton.click();
        return this;
    }

    @Step("Compare values with Web")
    public RegistrationPage compareValuesWithWeb() {
        assertEquals(newCustomerValues(), submitForm.submitFormValues());
        return this;
    }

    private String[] chooseRandomDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        LocalDate start = LocalDate.of(1950, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));

        String date = randomDate.format(formatter);
        String splitter[] = date.split(" ");

        if (splitter[0].startsWith("0")) {
            splitter[0] = splitter[0].replace("0", "");
            return splitter;
        } else {
            return splitter;
        }
    }

    private RegistrationPage closeDatePicker() {
        executeJavaScript("$('.react-datepicker').hide();");
        return this;
    }
}