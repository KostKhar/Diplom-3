import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import site.stellarburgers.nomoreparties.User;

public class BaseTest extends Driver {
    protected User user;

    protected String accessToken;

    // Random data for tests
    protected Faker faker = new Faker();
    protected String email = faker.internet().emailAddress();
    protected String password = faker.internet().password();
    protected String name = faker.internet().password();

    @Before
    public void setUp() throws InterruptedException {
        driver = initDriver(System.getProperty("webdriver.driver"));
        driver.get("https://stellarburgers.nomoreparties.site/");
        Thread.sleep(500);
    }

    @After
    public void browserQuit() {

            if (accessToken == null) {
                user.deleteUser("");
            } else {
                user.deleteUser(accessToken);
            }

        driver.quit();
    }

}
