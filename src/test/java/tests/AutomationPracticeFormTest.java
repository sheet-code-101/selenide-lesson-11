package tests;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;

public class AutomationPracticeFormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String phoneNumber = faker.number().digits(10);
    String birthYear = "1992";
    String birthMonth = "May";
    String birthDay = "19";
    String subject = "Math";
    String filePath = "src/test/resources/stock.jpeg";
    String fileName = "stock.jpeg";
    String address = faker.address().fullAddress();
    String state = "Rajasthan";
    String city = "Jaipur";

    @Test
    void formFillTest(){
        step("Fill registration form", () -> {
            step("Fill common data", () -> {
                practiceFormPage
                        .openPracticeFormPage()
                        .inputFirstName(firstName)
                        .inputLastName(lastName)
                        .inputEmail(email)
                        .selectGender(gender)
                        .inputPhoneNumber(phoneNumber);
            });

            step("Set date", () -> {
                practiceFormPage.setBirthDate(birthYear, birthMonth, birthDay);
            });

            step("Set subjects", () -> {
                practiceFormPage.inputSubject(subject);
            });

            step("Set image", () -> {
                practiceFormPage.uploadPicture(filePath);
            });

            step("Set address", () -> {
                practiceFormPage
                        .inputAddress(address)
                        .inputState(state)
                        .inputCity(city);
            });

            step("Submit form", () -> practiceFormPage.submitForm());

        });

        step("Verify form data", () -> {
            practiceFormPage
                    .checkStudentName(firstName + " " + lastName)
                    .checkStudentEmail(email)
                    .checkGenderValue(gender)
                    .checkPhoneNumber(phoneNumber)
                    .checkBirthDate(birthDay + " " + birthMonth + "," + birthYear)
                    .checkSubjectValue(subject)
                    .checkUploadedPicture(fileName)
                    .checkAddressValue(address)
                    .checkStateAndCityValues(state + " " + city);
        });

    }
}