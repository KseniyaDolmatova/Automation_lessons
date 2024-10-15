import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='select__wrapper']/button")
    private WebElement serviceTypeDropdown;

    // Услуги связи
    @FindBy(xpath = "//*[@class = 'select__list']/li[1]")
    private WebElement communicationServicesOption;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneInputCommunicationServices;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInputCommunicationServices;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailInputCommunicationServices;

    // Домашний интернет
    @FindBy(xpath = "//*[@class = 'select__list']/li[2]")
    private WebElement homeInternetOption;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement phoneInputHomeInternet;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement sumInputHomeInternet;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement emailInputHomeInternet;

    // Рассрочка
    @FindBy(xpath = "//*[@class = 'select__list']/li[3]")
    private WebElement instalmentOption;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement accountNumberInputInstallment;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement sumInputInstallment;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement emailInputInstallment;

    // Задолженность
    @FindBy(xpath = "//*[@class = 'select__list']/li[4]")
    private WebElement debtServicesOption;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement accountNumberInputDebt;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement sumInputDebt;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement emailInputDebt;

    // Проверка элементов в модальном окне
    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-1']/label")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-4']/label")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-5']/label")
    private WebElement cvcLabel;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-3']/label")
    private WebElement cardHolderNameLabel;

    @FindBy(xpath = "//div[contains(@class, 'cards-brands cards-brands__container')]//img")
    private List<WebElement> paymentIcons;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement displayedPhoneNumberElement;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement amountContainer;

    @FindBy(xpath = "//div[@class='card-page__card']/button")
    private WebElement payButton;


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Услуги связи
    public void selectCommunicationServices() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption)).click();
    }

    public String getPhoneInputPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(phoneInputCommunicationServices));
        return phoneInputCommunicationServices.getAttribute("placeholder");
    }

    public String getSumInputPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(sumInputCommunicationServices));
        return sumInputCommunicationServices.getAttribute("placeholder");
    }

    public String getEmailInputPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(emailInputCommunicationServices));
        return emailInputCommunicationServices.getAttribute("placeholder");
    }

    // Домашний интернет
    public void homeInternetService() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption)).click();
    }


    public String getPhoneInputPlaceholderInternetService() {
        wait.until(ExpectedConditions.visibilityOf(phoneInputHomeInternet));
        return phoneInputHomeInternet.getAttribute("placeholder");
    }

    public String getSumInputPlaceholderInternetService() {
        wait.until(ExpectedConditions.visibilityOf(sumInputHomeInternet));
        return sumInputHomeInternet.getAttribute("placeholder");
    }

    public String getEmailInputPlaceholderInternetService() {
        wait.until(ExpectedConditions.visibilityOf(emailInputHomeInternet));
        return emailInputHomeInternet.getAttribute("placeholder");
    }

    // Рассрочка
    public void installmentServicesService() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(instalmentOption)).click();
    }

    public String getAccountNumberPlaceholderInstallment() {
        wait.until(ExpectedConditions.visibilityOf(accountNumberInputInstallment));
        return accountNumberInputInstallment.getAttribute("placeholder");
    }

    public String getSumInputPlaceholderInstallment() {
        wait.until(ExpectedConditions.visibilityOf(sumInputInstallment));
        return sumInputInstallment.getAttribute("placeholder");
    }

    public String getEmailInputPlaceholderInstallment() {
        wait.until(ExpectedConditions.visibilityOf(emailInputInstallment));
        return emailInputInstallment.getAttribute("placeholder");
    }

    // Задолженность
    public void DebtServicesService() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(debtServicesOption)).click();
    }

    public String getAccountNumberPlaceholderDebt() {
        wait.until(ExpectedConditions.visibilityOf(accountNumberInputDebt));
        return accountNumberInputDebt.getAttribute("placeholder");
    }

    public String getSumInputPlaceholderDebt() {
        wait.until(ExpectedConditions.visibilityOf(sumInputDebt));
        return sumInputDebt.getAttribute("placeholder");
    }

    public String getEmailInputPlaceholderDebt() {
        wait.until(ExpectedConditions.visibilityOf(emailInputDebt));
        return emailInputDebt.getAttribute("placeholder");
    }

    //Проверка элементов на модальном окне
    public void openModalWindow() {
        serviceTypeDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(communicationServicesOption)).click();
        phoneInputCommunicationServices.sendKeys("297777777");
        sumInputCommunicationServices.sendKeys("100");
        continueButton.click();
    }

    public String getDisplayedPhoneNumber() {
        switchToIframe();
        wait.until(ExpectedConditions.visibilityOf(displayedPhoneNumberElement));
        String displayedText = displayedPhoneNumberElement.getText().trim();
        switchToDefaultContent();
        return displayedText.replaceAll(".*Номер:\\s*", "").trim();
    }

    public String getDisplayedAmount() {
        switchToIframe();
        wait.until(ExpectedConditions.visibilityOf(amountContainer));
        String amountText = amountContainer.getText().trim();
        switchToDefaultContent();
        return amountText;
    }

    public String getPaymentButtonText() {
        switchToIframe();
        wait.until(ExpectedConditions.visibilityOf(payButton));
        String buttonText = payButton.getText().trim();
        switchToDefaultContent();
        return buttonText;
    }

    public Map<String, String> getCardInputLabels() {
        switchToIframe();
        Map<String, String> labels = new HashMap<>();
        labels.put("cardNumber", cardNumberLabel.getText().trim());
        labels.put("expiryDate", expiryDateLabel.getText().trim());
        labels.put("cvc", cvcLabel.getText().trim());
        labels.put("cardHolderName", cardHolderNameLabel.getText().trim());
        switchToDefaultContent();
        return labels;
    }

    public List<String> getDisplayedPaymentIcons() {
        switchToIframe();
        List<String> icons = paymentIcons.stream()
                .map(icon -> icon.getAttribute("src"))
                .collect(Collectors.toList());
        switchToDefaultContent();
        return icons;
    }

    private void switchToIframe() {
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

