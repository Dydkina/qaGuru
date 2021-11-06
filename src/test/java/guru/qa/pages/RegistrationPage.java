package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

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

    public void fillName() {
        firstNameInput.setValue(firstNameValue);
        lastNameInput.setValue(lastNameValue);
    }

    public void fillEmail() {
        userEmailInput.setValue(emailValue);
    }

    public void chooseGender() {
        genderRadio.click();
    }

    public void fillPhoneNumber() {
        userNumber.setValue(phoneNumber);
    }

    public void setDateOfBirth() {
        dateOfBirthInput.click();
        datepickerYearDropDown.selectOption(year);
        datepickerMonthDropDown.selectOption(month_year);
        datepickerDayPicker.click();
        closeDatePicker();
    }

    public void setSubject() {
        subjectsContainer.click();
        subjectsInput.setValue(subjectsValue);
        subjectsDropDown.$(byText(subjectsValue)).click();
    }

    public void chooseHobby() {
        hobbyChekbox.$((byText(hobbiesValue))).click();
    }

    public void uploadPicture() {
        fileUpload.uploadFromClasspath(picValue);
    }

    public void fillAddres() {
        addressInput.setValue(addressValue);
    }

    public void selectStateAndCity() {
        stateDropDown.scrollIntoView(true);
        stateDropDown.click();
        stateDropDownElement.click();
        cityDropDown.click();
        cityDropDownElement.click();
    }

    public void submitClick() {
        submitButton.click();
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
        }
        return splitter;
    }

    private void closeDatePicker() {
        executeJavaScript("$('.react-datepicker').hide();");
    }

    public void compareValuesWithWeb() {
        assertEquals(newCustomerValues(), submitForm.submitFormValues());
    }
}