package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static org.testng.Assert.assertTrue;

@Feature("Registration Form")
@Story("User fills registration form and submits")

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("User fills the registration form with valid data")
    public void testFillRegistrationForm() {
        enterFirstName("John");
        enterLastName("Doe");
        enterEmail("john.doe@example.com");
        selectGender();
        enterMobile("1234567890");
        enterDateOfBirth("10 Nov 1985");
        enterSubjects("Maths");
        uploadPicture("path/to/picture.jpg");
        enterCurrentAddress("123 Main St");
        selectState("NCR");
        selectCity("Delhi");
        submitForm();

        // Verify the expected result
        assertTrue(isFormSubmitted());
    }

    @Step("Enter first name: {0}")
    public void enterFirstName(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @Step("Enter last name: {0}")
    public void enterLastName(String lastName) {
        registrationPage.enterLastName(lastName);
    }

    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @Step("Select gender")
    public void selectGender() {
        registrationPage.selectGender();
    }

    @Step("Enter mobile number: {0}")
    public void enterMobile(String mobile) {
        registrationPage.enterMobile(mobile);
    }

    @Step("Enter date of birth: {0}")
    public void enterDateOfBirth(String dateOfBirth) {
        registrationPage.enterDateOfBirth(dateOfBirth);
    }

    @Step("Enter subjects: {0}")
    public void enterSubjects(String subjects) {
        registrationPage.enterSubjects(subjects);
    }

    @Step("Upload picture: {0}")
    public void uploadPicture(String filePath) {
        registrationPage.uploadPicture(filePath);
    }

    @Step("Enter current address: {0}")
    public void enterCurrentAddress(String address) {
        registrationPage.enterCurrentAddress(address);
    }

    @Step("Select state: {0}")
    public void selectState(String state) {
        registrationPage.selectState(state);
    }

    @Step("Select city: {0}")
    public void selectCity(String city) {
        registrationPage.selectCity(city);
    }

    @Step("Submit the form")
    public void submitForm() {
        registrationPage.submitForm();
    }

    @Step("Check if the form is submitted")
    public boolean isFormSubmitted() {
        return driver.getPageSource().contains("Thanks for submitting the form");
    }
}