import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FieldLabelsInDebtTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    // Проверка надписей в незаполненных полях, "Задолженность"
    @Test public void testFieldLabelsInDebt() {
        paymentPage.DebtServicesService();

        // Проверка поля номера счета
        String accountNumberPlaceholder = paymentPage.getAccountNumberPlaceholderDebt();
        Assert.assertEquals(accountNumberPlaceholder, "Номер счета на 2073", "Надпись для счета неверна");

        // Проверка поля суммы
        String sumPlaceholder = paymentPage.getSumInputPlaceholderDebt();
        Assert.assertEquals(sumPlaceholder, "Сумма", "Надпись для суммы неверна");

        // Проверка email поля
        String emailPlaceholder = paymentPage.getEmailInputPlaceholderDebt();
        Assert.assertEquals(emailPlaceholder, "E-mail для отправки чека", "Надпись для email неверна");
    }

}

