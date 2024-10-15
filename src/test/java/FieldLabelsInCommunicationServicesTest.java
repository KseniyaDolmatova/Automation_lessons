import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FieldLabelsInCommunicationServicesTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    // Проверка надписей в незаполненных полях, "Услуги связи"
    @Test public void testFieldLabelsInCommunicationServices() {
        paymentPage.selectCommunicationServices();

        // Проверка поля телефон
        String phonePlaceholder = paymentPage.getPhoneInputPlaceholder();
        Assert.assertEquals(phonePlaceholder, "Номер телефона", "Надпись для телефона неверна");

        // Проверка поля суммы
        String sumPlaceholder = paymentPage.getSumInputPlaceholder();
        Assert.assertEquals(sumPlaceholder, "Сумма", "Надпись для суммы неверна");

        // Проверка поля email
        String emailPlaceholder = paymentPage.getEmailInputPlaceholder();
        Assert.assertEquals(emailPlaceholder, "E-mail для отправки чека", "Надпись для email неверна");
    }

}

