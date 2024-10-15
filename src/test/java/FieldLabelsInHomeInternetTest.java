import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FieldLabelsInHomeInternetTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    // Проверка надписей в незаполненных полях, "Домашний интернет"
    @Test public void testFieldLabelsInHomeInternet() {
        paymentPage.homeInternetService();

        // Проверка поля телефона
        String phonePlaceholder = paymentPage.getPhoneInputPlaceholderInternetService();
        Assert.assertEquals(phonePlaceholder, "Номер абонента", "Надпись для телефона неверна");

        // Проверка поля суммы
        String sumPlaceholder = paymentPage.getSumInputPlaceholderInternetService();
        Assert.assertEquals(sumPlaceholder, "Сумма", "Надпись для суммы неверна");

        // Проверка поля email
        String emailPlaceholder = paymentPage.getEmailInputPlaceholderInternetService();
        Assert.assertEquals(emailPlaceholder, "E-mail для отправки чека", "Надпись для email неверна");
    }

}

