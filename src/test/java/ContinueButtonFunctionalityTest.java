import org.testng.Assert;
import org.testng.annotations.Test;

public class ContinueButtonFunctionalityTest extends BaseTest {

    @Test
    public void testContinueButtonFunctionality() {

        paymentPage.enterSum("100");
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.clickContinueButton();
        paymentPage.switchToPaymentFrame();

        Assert.assertTrue(paymentPage.isModalVisible(), "Модальное окно не отображается.");
    }
}