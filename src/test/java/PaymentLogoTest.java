import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentLogoTest extends BaseTest {
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testVisaLogo() {
        Assert.assertTrue(paymentPage.isVisaLogoDisplayed(), "Логотип Visa не отображается.");
    }

    @Test
    public void testVerifiedByVisaLogo() {
        Assert.assertTrue(paymentPage.isVerifiedByVisaLogoDisplayed(), "Логотип Verified By Visa не отображается.");
    }

    @Test
    public void testMastercardLogo() {
        Assert.assertTrue(paymentPage.isMastercardLogoDisplayed(), "Логотип MasterCard не отображается.");
    }

    @Test
    public void testMasterCardSecureLogo() {
        Assert.assertTrue(paymentPage.isMasterCardSecureLogoDisplayed(), "Логотип MasterCard Secure не отображается.");
    }

    @Test public void testBelkartLogo() {
        Assert.assertTrue(paymentPage.isBelkartLogoDisplayed(), "Логотип Белкарт не отображается.");
    }
}