package pages;

import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private Calendar calendar = new Calendar();

    public PracticeFormPage openPracticeFormPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PracticeFormPage inputFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeFormPage inputLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PracticeFormPage inputEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PracticeFormPage inputPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public PracticeFormPage setBirthDate(String year, String month, String day) {
        calendar.setDate(year, month, day);
        return this;
    }

    public PracticeFormPage inputSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage uploadPicture(String path) {
        $("#uploadPicture").uploadFile(new File(path));
        return this;
    }

    public PracticeFormPage inputAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public PracticeFormPage inputState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public PracticeFormPage inputCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public void submitForm() {
        $("#submit").click();
    }

    public PracticeFormPage checkStudentName(String studentName) {
        $("tbody").$(byText("Student Name")).parent().shouldHave(text(studentName));
        return this;
    }

    public PracticeFormPage checkStudentEmail(String studentEmail) {
        $("tbody").$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        return this;
    }

    public PracticeFormPage checkGenderValue(String genderValue) {
        $("tbody").$(byText("Gender")).parent().shouldHave(text(genderValue));
        return this;
    }

    public PracticeFormPage checkPhoneNumber(String phoneNumber) {
        $("tbody").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        return this;
    }

    public PracticeFormPage checkBirthDate(String birthDate) {
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text(birthDate));
        return this;
    }

    public PracticeFormPage checkSubjectValue(String subjectValue) {
        $("tbody").$(byText("Subjects")).parent().shouldHave(text(subjectValue));
        return this;
    }

    public PracticeFormPage checkUploadedPicture(String uploadedPictureName) {
        $("tbody").$(byText("Picture")).parent().shouldHave(text(uploadedPictureName));
        return this;
    }

    public PracticeFormPage checkAddressValue(String addressValue) {
        $("tbody").$(byText("Address")).parent().shouldHave(text(addressValue));
        return this;
    }

    public PracticeFormPage checkStateAndCityValues(String stateAndCityValues) {
        $("tbody").$(byText("State and City")).parent().shouldHave(text(stateAndCityValues));
        return this;
    }
}