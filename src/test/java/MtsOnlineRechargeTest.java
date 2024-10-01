import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MtsOnlineRechargeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        // Принять куки
        acceptCookies();
    }

    private void acceptCookies() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookie-agree\"]")));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять' не найдена: " + e.getMessage());
        }
    }

    @Test
    public void testPaymentSystemLogos() {
        // Ожидаем, пока логотипы Visa и MasterCard станут видимыми
        WebElement visaLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")));
        WebElement mastercardLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")));

        // Проверяем, отображаются ли логотипы
        Assert.assertTrue(visaLogo.isDisplayed(), "Логотип Visa не отображается.");
        Assert.assertTrue(mastercardLogo.isDisplayed(), "Логотип MasterCard не отображается.");
    }

    @Test
    public void testMoreInfoLink() {
        // Ищем элемент ссылки на 'Подробнее о сервисе'
        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a")));

        // Проверяем, что href доступен
        String linkHref = moreInfoLink.getAttribute("href");
        Assert.assertNotNull(linkHref, "Ссылка на 'Подробнее о сервисе' отсутствует.");

        // Клик по ссылке
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", moreInfoLink);

        // Ожидаем, пока новая страница загрузится, и проверяем заголовок
        wait.until(ExpectedConditions.titleIs("Порядок оплаты и безопасность интернет платежей"));
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей", "Переход по ссылке не сработал.");

        // Проверка URL
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"; // Замените на фактический ожидаемый URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL не соответствует ожидаемому после перехода.");

        // Возвращаемся на предыдущую страницу
        driver.navigate().back();
    }

    @Test
    public void testContinueButtonFunctionality() {
        // Заполнение формы
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button")));
        serviceTypeDropdown.click();

        // Выбираем «Услуги связи»
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Услуги связи']")));
        serviceOption.click();

        // Заполняем телефон
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberInput.sendKeys("297777777");

        // Заполняем сумму
        WebElement sum = driver.findElement(By.cssSelector("#connection-sum")); // Убедитесь, что здесь правильный селектор
        sum.sendKeys("100");

        // Нажимаем на кнопку
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        // Проверка появления модального окна
        WebElement modalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a")));

        Assert.assertTrue(modalWindow.isDisplayed(), "Модальное окно не отображается.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}