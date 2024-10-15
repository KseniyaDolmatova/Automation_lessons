import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FieldLabelsInInstallmentTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    // Проверка надписей в незаполненных полях, "Рассрочка"
    @Test public void testFieldLabelsInInstallment() {
        paymentPage.installmentServicesService();

        // Проверка поля номера счета
        String accountNumberPlaceholder = paymentPage.getAccountNumberPlaceholderInstallment();
        Assert.assertEquals(accountNumberPlaceholder, "Номер счета на 44", "Надпись для номера счета неверна");

        // Проверка поля суммы
        String sumPlaceholder = paymentPage.getSumInputPlaceholderInstallment();
        Assert.assertEquals(sumPlaceholder, "Сумма", "Надпись для суммы неверна");

        // Проверка поля email
        String emailPlaceholder = paymentPage.getEmailInputPlaceholderInstallment();
        Assert.assertEquals(emailPlaceholder, "E-mail для отправки чека", "Надпись для email неверна");
    }

}


