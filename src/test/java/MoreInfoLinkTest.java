import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoreInfoLinkTest extends BaseTest {
    private PaymentPage paymentPage;

    @BeforeClass public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testMoreInfoLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = paymentPage.clickMoreInfoLinkAndGetUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL не соответствует ожидаемому после перехода.");
    }
}
