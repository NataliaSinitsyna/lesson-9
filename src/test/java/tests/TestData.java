package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String address = faker.address().streetAddress();
    String userPhone = faker.phoneNumber().subscriberNumber(10);
    String userPhoto = "20.jpg";

    Date date = faker.date().birthday(18, 65);
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String[] randomDate = formatter.format(date).split(" ");

    String[] gender = {"Male", "Female", "Other"};
    String userGender = faker.options().option(gender);

    String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies", "English", "Chemistry",
    "Computer Science", "Commerce", "Economics", "Social Studies", "Biology", "History"};
    String userSubjects = faker.options().option(subjects);

    String[] hobbies = {"Sports", "Reading", "Music"};
    String userHobbies = faker.options().option(hobbies);

    String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String userState = faker.options().option(state);

    public String getCity() {
        String userCity = new String();
        if (Objects.equals(userState, "NCR")) {
            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
            userCity = faker.options().option(cityNCR);
        } else if (Objects.equals(userState, "Uttar Pradesh")) {
            String[] cityUP = {"Agra", "Lucknow", "Merrut"};
            userCity = faker.options().option(cityUP);
        } else if (Objects.equals(userState, "Haryana")) {
            String[] cityH = {"Karnal", "Panipat"};
            userCity = faker.options().option(cityH);
        } else if (Objects.equals(userState, "Rajasthan")) {
            String[] cityR = {"Jaipur", "Jaiselmer"};
            userCity = faker.options().option(cityR);
        }

        return userCity;
    }


}
