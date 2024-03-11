package site.stellarburgers.nomoreparties;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    // Конструктор
    private final By designer = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    //    Проверь переход по клику на «Личный кабинет».
    // Лента заказов
    private final By listOrders = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Лента Заказов']");
    // stellar burgers
    private final By stellarBurgers = By.xpath(".//div/a");
    // Личный кабинет
    private final By personalAccount = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private final By signIn = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    // Войти в аккаунт
    //            «Булки»,
    private final By bun = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    //Флюоресцентная булка
    private final By bunR2D3 = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Флюоресцентная булка R2-D3']");
    private final By sauce = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Соус с шипами Антарианского плоскоходца
    private final By sauceWithShips = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Соус с шипами Антарианского плоскоходца']");

    //            «Соусы»,
    private final By filling = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By fillingProtostomia = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='Мясо бессмертных моллюсков Protostomia']");

    //            «Начинки».
    // Оформить заказ
    private final By createOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");

    //Мясо бессмертных моллюсков Protostomia

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getBun() {
        return bun;
    }

    public By getCreateOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(createOrder));
        return createOrder;
    }

    @Step("Клик по личому кабинету")
    public void clickPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(personalAccount));
        driver.findElement(personalAccount).click();
    }

    public void clickSignIn() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(signIn));
        driver.findElement(signIn).click();
    }

    public boolean clickBun() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sauce));

        try {
            driver.findElement(sauce).click();
            driver.findElement(bun).click();
        } catch (NullPointerException e) {
            Thread.sleep(500);
            driver.findElement(sauce).click();
            driver.findElement(bun).click();
        }
        return driver.findElement(bunR2D3).isDisplayed();
    }

    public boolean clickSauce() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sauce));
        driver.findElement(sauce).click();
        return driver.findElement(sauceWithShips).isDisplayed();
    }

    public boolean clickFilling() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(filling));
        driver.findElement(filling).click();
        return driver.findElement(fillingProtostomia).isDisplayed();
    }


}
