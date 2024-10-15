import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BlockTitleTest extends BaseTest {
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        Assert.assertEquals(title, "Онлайн пополнение\nбез комиссии", "Название блока неверно.");
    }
}
