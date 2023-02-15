package tests;

import org.junit.jupiter.api.Test;

import java.text.ParseException;


public class RegistrationFormTests extends TestBase {

    TestData data = new TestData();
    @Test
    void successRegistrationTest() throws ParseException {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.userGender)
                .setPhone(data.userPhone)
                .setBirthDate(data.randomDate[0], data.randomDate[1], data.randomDate[2])
                .setSubject(data.userSubjects)
                .setHobbies(data.userHobbies)
                .uploadFile(data.userPhoto)
                .setAddress(data.address)
                .setState(data.userState)
                .setCity(data.getCity())
                .setButton();

        registrationPage.verifyResultsModalAppears().
                verifyResult("Student Name", data.firstName+" "+data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.userGender)
                .verifyResult("Mobile", data.userPhone)
                .verifyResult("Date of Birth", data.randomDate[0]+" "+data.randomDate[1]+
                        ","+data.randomDate[2])
                .verifyResult("Subjects", data.userSubjects)
                .verifyResult("Hobbies", data.userHobbies)
                .verifyResult("Picture", data.userPhoto)
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.userState+" "+data.getCity());
    }

}