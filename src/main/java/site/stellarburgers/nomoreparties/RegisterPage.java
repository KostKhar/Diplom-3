package site.stellarburgers.nomoreparties;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    // Имя
    private final By nameField = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default']");
    // Email
    private final By emailField = By.xpath(".//fieldset[2]//input[@class='text input__textfield text_type_main-default']");
    // Пароль
    private final By passwordField = By.xpath(".//fieldset[3]//input[@class='text input__textfield text_type_main-default']");
    // Зарегистрироваться
    private final By signUpButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    // Войти
    private final By signInButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public By getSignInBlock() {
        return signInBlock;
    }

    // Блок с заголовком Войти
    private final By signInBlock = By.xpath(".//div/h2[text()='Вход']");
    private final By personalAccount = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    // личный кабинет
    private final By invalidPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    // Некорректный пароль

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поля при регистрации")
    public void filledField(String name, String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Войти в форме регистрации")
    public void clickSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(signInButton).click();
    }

    @Step("Нажать кнопку Зарегистрироваться в форме регистрации")
    public void clickSignUpButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(signUpButton).click();
    }

    public boolean checkInvalidPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(nameField));
        return driver.findElement(invalidPassword).isDisplayed();
    }

}
