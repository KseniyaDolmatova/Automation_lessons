import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VerifyModalInformationTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeClass
    @Override public void setUp() {
        super.setUp();
        paymentPage = new PaymentPage(driver);
    }

    // Проверка элементов в модальном окне
    @Test public void testVerifyModalInformation() {
        paymentPage.openModalWindow();

        // Проверка номера телефона
        String actualPhoneNumber = paymentPage.getDisplayedPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, "375297777777", "Телефон отображается неверно");

        // Проверка суммы
        String actualAmount = paymentPage.getDisplayedAmount();
        Assert.assertEquals(actualAmount, "100.00 BYN", "Сумма неверна");

        // Проверка суммы на кнопке
        String buttonText = paymentPage.getPaymentButtonText();
        Assert.assertTrue(buttonText.contains("100.00 BYN"), "Сумма на кнопке неверна");

        // Проверка наличия надписей в полях для реквизитов карты
        Map<String, String> labels = paymentPage.getCardInputLabels();
        Assert.assertEquals(labels.get("cardNumber"), "Номер карты", "Надпись для номера карты неверна");
        Assert.assertEquals(labels.get("expiryDate"), "Срок действия", "Надпись для срока действия неверна");
        Assert.assertEquals(labels.get("cvc"), "CVC", "Надпись для CVC неверна");
        Assert.assertEquals(labels.get("cardHolderName"), "Имя держателя (как на карте)", "Надпись для имени держателя карты неверна");

        // Проверка наличия иконок платёжных систем
        List<String> icons = paymentPage.getDisplayedPaymentIcons();
        List<String> expectedIcons = Arrays.asList(
                "visa-system.svg",
                "mastercard-system.svg",
                "belkart-system.svg",
                "maestro-system.svg",
                "mir-system-ru.svg"
        );

        Assert.assertFalse(icons.isEmpty(), "Иконки платёжной системы не отображаются");

        for (String expectedIcon : expectedIcons) {
            boolean iconFound = icons.stream().anyMatch(icon -> icon.endsWith(expectedIcon));
            Assert.assertTrue(iconFound, "Иконка " + expectedIcon + " отсутствует на странице");
        }

        // Проверка иконок Maestro и Mir
        boolean maestroDisplayed = icons.stream().anyMatch(icon -> icon.endsWith("maestro-system.svg"));
        boolean mirDisplayed = icons.stream().anyMatch(icon -> icon.endsWith("mir-system-ru.svg"));

        Assert.assertTrue(maestroDisplayed || mirDisplayed, "Не отображаются ни иконки Maestro, ни Mir");
    }

}
