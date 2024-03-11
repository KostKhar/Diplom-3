import org.junit.After;
import org.junit.Before;

public class BaseTest extends Driver {

    @Before
    public void setUp() throws InterruptedException {
        driver = initDriver(System.getProperty("webdriver.driver"));
        driver.get("https://stellarburgers.nomoreparties.site/");
        Thread.sleep(500);
    }

    @After
    public void browserQuit() {
        driver.quit();
    }

}
