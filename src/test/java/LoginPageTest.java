import io.restassured.RestAssured;
import org.junit.Test;
import site.stellarburgers.nomoreparties.*;

import static org.junit.Assert.assertTrue;

public class LoginPageTest extends BaseTest {

    @Override
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        user = new User(email, password, name);
        accessToken = user.createUser().then().extract().path("accessToken");
        driver = initDriver(System.getProperty("webdriver.driver"));
        driver.get("https://stellarburgers.nomoreparties.site/");
    }


    //    Проверь переход по клику на «Личный кабинет».
    @Test
    public void checkPersonalAccount() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();

        assertTrue(driver.findElement(new LoginPage(driver).getEmailField()).isDisplayed());
    }

    //    вход по кнопке «Войти в аккаунт» на главной,
    @Test
    public void checkSignInButtonFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignIn();
        loginPage.pressSignInButton(email, password);

        assertTrue(driver.findElement(mainPage.getCreateOrder()).isDisplayed());
    }

    //    вход через кнопку в форме регистрации,
    @Test
    public void checkSignInButtonFromRegisterPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.pressSignUpButton();
        registerPage.clickSignInButton();
        loginPage.pressSignInButton(email, password);

        assertTrue(driver.findElement(mainPage.getCreateOrder()).isDisplayed());
    }

    //    вход через кнопку в форме восстановления пароля.
    @Test
    public void checkSignInButtonFromRegisterPageByRecoveryPass() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.clickForgotPassword();
        forgotPasswordPage.clickSignIn();
        loginPage.pressSignInButton(email, password);

        assertTrue(driver.findElement(mainPage.getCreateOrder()).isDisplayed());
    }

    //    Проверь выход по кнопке «Выйти» в личном кабинете.
    @Test
    public void checkSignOutButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignIn();
        loginPage.pressSignInButton(email, password);
        mainPage.clickPersonalAccount();
        loginPage.clickSignOut();

        assertTrue(driver.findElement(loginPage.getSignUpButton()).isDisplayed());
    }


    //    Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
    @Test
    public void checkDesignerButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.clickDesigner();

        assertTrue(driver.findElement(mainPage.getBun()).isDisplayed());
    }

    @Test
    public void checkStellarBurgerButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.clickStellarBurgers();

        assertTrue(driver.findElement(mainPage.getBun()).isDisplayed());
    }


}
