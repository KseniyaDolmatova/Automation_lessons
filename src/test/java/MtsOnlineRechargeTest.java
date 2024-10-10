import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MtsOnlineRechargeTest {
    private WebDriver driver;
    private HomePage homePage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        // Инициализация страниц
        homePage = new HomePage(driver);
        paymentPage = new PaymentPage(driver);

        // Принять куки
        homePage.acceptCookies();
    }

    @Test (priority = 1)
    public void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        Assert.assertEquals(title, "Онлайн пополнение\nбез комиссии", "Название блока неверно.");
    }

    @Test (priority = 2)
    public void testPaymentSystemLogos() {
        paymentPage.checkPaymentLogos();
    }

    @Test (priority = 3)
    public void testMoreInfoLink() {
        paymentPage.checkMoreInfoLink();
    }

    @Test (priority = 4)
    public void testContinueButtonFunctionality() {
        paymentPage.fillFormAndCheckContinueButton("297777777", "100");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
