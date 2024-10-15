import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FieldLabelsInInternetPageTest extends BaseTest {
    private HomeInternetPage homeInternetPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        homeInternetPage = new HomeInternetPage(driver);
    }

    @Test
    public void testFieldLabelsInInternetPage() {
        homeInternetPage.homeInternetService();
        homeInternetPage.checkPhoneField();
        homeInternetPage.checkSumField();
        homeInternetPage.checkEmailField();
    }
}
