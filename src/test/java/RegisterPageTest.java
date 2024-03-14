import io.restassured.RestAssured;
import org.junit.Test;
import site.stellarburgers.nomoreparties.RegisterPage;
import site.stellarburgers.nomoreparties.User;

import static org.junit.Assert.assertTrue;

public class RegisterPageTest extends BaseTest {


    @Override
    public void setUp() throws InterruptedException {
        driver = initDriver(System.getProperty("webdriver.driver"));
        driver.get("https://stellarburgers.nomoreparties.site/register");
        Thread.sleep(500);

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        user = new User(email, password);
    }


//    Успешную регистрацию.

    @Test
    public void checkRegistrationValid() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.filledField(name, email, password);
        registerPage.clickSignUpButton();
        accessToken = user.loginUser().then().extract().path("accessToken");

        assertTrue(driver.findElement(registerPage.getSignInBlock()).isDisplayed());
    }

    //    Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
    @Test
    public void checkRegistrationWithInvalidPassword() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.filledField(name, email, "1234");
        registerPage.clickSignUpButton();

        assertTrue(registerPage.checkInvalidPassword());
    }


}
