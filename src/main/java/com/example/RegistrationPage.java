package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='gender' and @value='Male']")
    private WebElement genderMaleRadio;

    @FindBy(id = "userNumber")
    private WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(id = "uploadPicture")
    private WebElement pictureUpload;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectGender() {
        genderMaleRadio.click();
    }

    public void enterMobile(String mobile) {
        mobileInput.sendKeys(mobile);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        dateOfBirthInput.sendKeys(dateOfBirth);
        dateOfBirthInput.sendKeys(Keys.RETURN);
    }

    public void enterSubjects(String subjects) {
        subjectsInput.sendKeys(subjects);
        subjectsInput.sendKeys(Keys.RETURN);
    }

    public void uploadPicture(String filePath) {
        pictureUpload.sendKeys(filePath);
    }

    public void enterCurrentAddress(String address) {
        currentAddressInput.sendKeys(address);
    }

    public void selectState(String state) {
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.RETURN);
    }

    public void selectCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.RETURN);
    }

    public void submitForm() {
        submitButton.click();
    }
}