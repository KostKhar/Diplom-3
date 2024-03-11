import io.restassured.RestAssured;
import org.junit.Test;
import org.openqa.selenium.By;
import site.stellarburgers.nomoreparties.RegisterPage;
import site.stellarburgers.nomoreparties.User;

import static org.junit.Assert.assertTrue;

public class RegisterPageTest extends BaseTest {
    private User user;

    private String accessToken;

    @Override
    public void setUp() throws InterruptedException {
        driver = initDriver(System.getProperty("webdriver.driver"));
        driver.get("https://stellarburgers.nomoreparties.site/register");
        Thread.sleep(500);
    }


//    Успешную регистрацию.

    @Test
    public void checkRegistrationValid() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.filledField("Nick", "yandex@testtest.ru", "Pass1234");
        registerPage.clickSignUpButton();

        assertTrue(driver.findElement(By.xpath(".//div/h2[text()='Вход']")).isDisplayed());
    }

    //    Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
    @Test
    public void checkRegistrationWithInvalidPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.filledField("Nick", "yandex@testtest.ru", "1234");
        registerPage.clickSignUpButton();

        assertTrue(registerPage.checkInvalidPassword());
    }

    @Override
    public void browserQuit() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";

        user = new User("yandex@testtest.ru", "Pass1234");
        accessToken = user.loginUser().then().extract().path("accessToken");

        if (accessToken == null) {
            user.deleteUser("");
        } else {
            user.deleteUser(accessToken);
        }
        driver.quit();
    }

}
