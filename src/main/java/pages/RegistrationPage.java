package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("userEmail");
    private By genderMaleRadio = By.xpath("//label[text()='Male']");
    private By mobileInput = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By subjectsInput = By.id("subjectsInput");
    private By pictureUpload = By.id("uploadPicture");
    private By addressInput = By.id("currentAddress");
    private By stateDropdown = By.id("react-select-3-input");
    private By cityDropdown = By.id("react-select-4-input");
    private By submitButton = By.id("submit");
    private By successMessage = By.xpath("//div[contains(text(), 'Thanks for submitting the form')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void fillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void selectGender() {
        driver.findElement(genderMaleRadio).click();
    }

    public void fillMobile(String mobile) {
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void fillDateOfBirth(String date) {
        driver.findElement(dateOfBirthInput).click();
        driver.findElement(dateOfBirthInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(dateOfBirthInput).sendKeys(date);
        driver.findElement(dateOfBirthInput).sendKeys(Keys.ENTER);
    }

    public void fillSubjects(String subjects) {
        driver.findElement(subjectsInput).sendKeys(subjects);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public void uploadPicture(String filePath) {
        driver.findElement(pictureUpload).sendKeys(filePath);
    }

    public void fillCurrentAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectState(String state) {
        driver.findElement(stateDropdown).sendKeys(state);
        driver.findElement(stateDropdown).sendKeys(Keys.ENTER);
    }

    public void selectCity(String city) {
        driver.findElement(cityDropdown).sendKeys(city);
        driver.findElement(cityDropdown).sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  driver.findElement(submitButton));
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}
