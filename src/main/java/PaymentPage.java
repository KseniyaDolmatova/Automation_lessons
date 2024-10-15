import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"connection-phone\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement sumField;


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Инициализация элементов
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOf(blockTitle)).getText();
    }

    public boolean isVisaLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(visaLogo)).isDisplayed();
    }

    public boolean isVerifiedByVisaLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(verifiedByVisaLogo)).isDisplayed();
    }

    public boolean isMastercardLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(mastercardLogo)).isDisplayed();
    }

    public boolean isMasterCardSecureLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(masterCardSecureLogo)).isDisplayed();
    }

    public boolean isBelkartLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(belkartLogo)).isDisplayed();
    }

    public String clickMoreInfoLinkAndGetUrl() {
        moreInfoLink.click();
        wait.until(ExpectedConditions.titleIs("Порядок оплаты и безопасность интернет платежей"));
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        return currentUrl;
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterSum(String sum) {
        sumField.clear();
        sumField.sendKeys(sum);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));
                }

    public boolean isModalVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'app-wrapper__content-container app-wrapper__content-container_full')]"))).isDisplayed();
        }
}