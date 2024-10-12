import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MtsOnlineRechargeTest2 {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private CommunicationServicesPage communicationServicesPage;
    private HomeInternetPage homeInternetPage;
    private InstallmentPage installmentPage;
    private DebtPage debtPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        homePage = new HomePage(driver);
        communicationServicesPage = new CommunicationServicesPage(driver);
        homeInternetPage = new HomeInternetPage(driver);
        installmentPage = new InstallmentPage(driver);
        debtPage = new DebtPage(driver);

        homePage.acceptCookies();
    }

    @Test (priority = 1)
    public void testFieldLabelsInCommunicationServices() {
        // Выбор типа сервиса "Услуги связи"
        communicationServicesPage.selectCommunicationServices();

        // Проверка полей
        communicationServicesPage.checkPhoneField();
        communicationServicesPage.checkSumField();
        communicationServicesPage.checkEmailField();
    }

    @Test (priority = 2)
    public void testFieldLabelsInInternetPage() {
        // Выбор типа сервиса "Домашний  интернет"
        homeInternetPage.homeInternetService();

        // Проверка полей
        homeInternetPage.checkPhoneField();
        homeInternetPage.checkSumField();
        homeInternetPage.checkEmailField();
    }

    @Test (priority = 3)
    public void testFieldLabelsInlmentServices() {
        // Выбор типа сервиса "Рассрочка"
        installmentPage.installmentServicesService();

        // Проверка полей
        installmentPage.checkAccountNumber();
        installmentPage.checkSumField();
        installmentPage.checkEmailField();
    }

    @Test (priority = 4)
    public void testFieldLabelsInDebtServices() {
        // Выбор типа сервиса "Задолженность"
        debtPage.DebtServicesService();

        // Проверка полей
        debtPage.checkAccountNumber();
        debtPage.checkSumField();
        debtPage.checkEmailField();
    }

    @Test(priority = 5)
    public void testVerifyModalInformation() {

        // Открытие модального окна и проверка надписей
        OpenModalWindow openModalWindow = new OpenModalWindow(driver);
        openModalWindow.openModalWindow();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}