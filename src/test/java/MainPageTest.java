import org.junit.Test;
import site.stellarburgers.nomoreparties.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {
//  переход к   «Булки»,

    @Test
    public void checkBunIsVisible() throws InterruptedException {
        assertTrue(new MainPage(driver).clickBun());
    }

    //  переход к «Соусы»,
    @Test
    public void checkSauceIsVisible() {
        assertTrue(new MainPage(driver).clickSauce());
    }

    //  переход к «Начинки».
    @Test
    public void checkFillingIsVisible() {
        assertTrue(new MainPage(driver).clickFilling());
    }

}
