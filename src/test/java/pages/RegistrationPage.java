package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import pages.components.UploadFileComponent;

import com.github.javafaker.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private UploadFileComponent uploadFileComponent = new UploadFileComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            subjectPhisics = $("#react-select-2-option-0"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            buttonInput = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectPhisics.click(); //неуниверсавльная конструкция

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile(String value) {
        uploadFileComponent.addFile(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setButton() {
        buttonInput.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
