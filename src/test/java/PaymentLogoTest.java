import org.testng.annotations.Test;

public class PaymentLogoTest extends BaseTest {

    @Test
    public void testVisaLogo() {
        paymentPage.checkVisaLogo();
    }

    @Test public void testVerifiedByVisaLogo() {
        paymentPage.checkVerifiedByVisaLogo();
    }

    @Test public void testMastercardLogo() {
        paymentPage.checkMastercardLogo();
    }

    @Test public void testMasterCardSecureLogo() {
        paymentPage.checkMasterCardSecureLogo();
    }

    @Test public void testBelkartLogo() {
        paymentPage.checkBelkartLogo();
    }
}