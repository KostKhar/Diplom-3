package site.stellarburgers.nomoreparties;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    // Имя
    private final By emailField = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default']");

    // Пароль
    private final By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");


    // Войти
    private final By signInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Зарегистрироваться
    private final By signUpButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    //Конструктор
    private final By designer = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    // stellar burgers
    private final By stellarBurgers = By.xpath(".//div/a");
    // кнопка Выход
    private final By signOut = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");
    // Восстановить пароль
    private final By forgotPassword = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Клик на кнопку Восстановить пароль")
    public void clickForgotPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(forgotPassword));
        driver.findElement(forgotPassword).click();
    }

    // клик на конструктор
    public void clickDesigner() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(designer));
        driver.findElement(designer).click();
    }

    // клик на эмблему бургеров
    public void clickStellarBurgers() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(stellarBurgers));
        driver.findElement(stellarBurgers).click();
    }

    // клик на на кнопку Выход в личном кабинете

    @Step("Клик по кнопке Выход")
    public void clickSignOut() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(signOut));
        driver.findElement(signOut).click();
    }

    @Step("Нажать на кнокпу Зарегистрироваться")
    public void pressSignUpButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(signUpButton));
        driver.findElement(signUpButton).click();
    }

    public By getEmailField() throws InterruptedException {
        Thread.sleep(15);
        return emailField;
    }

    public void pressSignInButton(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public By getSignUpButton() {
        return signUpButton;
    }

}
