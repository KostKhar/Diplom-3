package site.stellarburgers.nomoreparties;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    // кнопка Войти
    private final By signInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на Войти в форме восставноления пароля")
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}
