import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Улучшенные локаторы
    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement blockTitle;

    @FindBy(xpath = "//*[@id='pay-section']//img[@alt='Visa']")
    private WebElement visaLogo;

    @FindBy(xpath = "//*[@id='pay-section']//img[@alt='Verified By Visa']")
    private WebElement verifiedByVisaLogo;

    @FindBy(xpath = "//*[@id='pay-section']//img[@alt='MasterCard']")
    private WebElement mastercardLogo;

    @FindBy(xpath = "//*[@id='pay-section']//img[@alt='MasterCard Secure Code']")
    private WebElement masterCardSecureLogo;

    @FindBy(xpath = "//*[@id='pay-section']//img[@alt='Белкарт']")
    private WebElement belkartLogo;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement moreInfoLink;

    @FindBy(css = "#pay-connection > button")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"connection-phone\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement sumField;

    @FindBy(css = ".select__header")
    private WebElement serviceTypeSelector;

    @FindBy(css = ".select__option")
    private WebElement serviceTypeOption;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Инициализация элементов
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOf(blockTitle)).getText();
    }

    public void checkPaymentLogos() {
        if (!visaLogo.isDisplayed()) {
            throw new AssertionError("Логотип Visa не отображается.");
        }
        if (!verifiedByVisaLogo.isDisplayed()) {
            throw new AssertionError("Логотип Verified By Visa не отображается.");
        }
        if (!mastercardLogo.isDisplayed()) {
            throw new AssertionError("Логотип MasterCard не отображается.");
        }
        if (!masterCardSecureLogo.isDisplayed()) {
            throw new AssertionError("Логотип MasterCard Secure не отображается.");
        }
        if (!belkartLogo.isDisplayed()) {
            throw new AssertionError("Логотип Белкарт не отображается.");
        }

    }

    public void checkMoreInfoLink() {
        moreInfoLink.click();
        wait.until(ExpectedConditions.titleIs("Порядок оплаты и безопасность интернет платежей"));
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        if (!driver.getCurrentUrl().equals(expectedUrl)) {
            throw new AssertionError("URL не соответствует ожидаемому после перехода.");
        }
        driver.navigate().back();
    }

    public void fillFormAndCheckContinueButton(String phoneNumber, String sum) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        sumField.clear();
        sumField.sendKeys(sum);
        serviceTypeSelector.click();
        serviceTypeOption.click();
        continueButton.click();

        // Переключение на фрейм
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));

        // Проверка, отображается ли модальное окно
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'app-wrapper__content-container app-wrapper__content-container_full')]")));

    }
}