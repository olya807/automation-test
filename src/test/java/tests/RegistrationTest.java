package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.WebDriverManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    Path relativePath = Paths.get("src/test/resources/files");
    String absolutePath = relativePath.toAbsolutePath().toString();

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testRegistrationForm() {
        registrationPage.fillFirstName("John");
        registrationPage.fillLastName("Doe");
        registrationPage.fillEmail("john.doe@example.com");
        registrationPage.selectGender();
        registrationPage.fillMobile("1234567890");
        registrationPage.fillDateOfBirth("10 Nov 1985");
        registrationPage.fillSubjects("Maths");
        registrationPage.uploadPicture(absolutePath + "/cat.jpg");
        registrationPage.fillCurrentAddress("123 Main St");
        registrationPage.selectState("NCR");
        registrationPage.selectCity("Delhi");
        registrationPage.submitForm();

        Assert.assertTrue(registrationPage.isSuccessMessageDisplayed(), "Success message is not displayed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}