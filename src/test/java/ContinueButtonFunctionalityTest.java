import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContinueButtonFunctionalityTest extends BaseTest {
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testContinueButtonFunctionality() {

        paymentPage.enterSum("100");
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.clickContinueButton();
        paymentPage.switchToPaymentFrame();

        Assert.assertTrue(paymentPage.isModalVisible(), "Модальное окно не отображается.");
    }
}