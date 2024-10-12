import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


class CommunicationServicesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".select__header")
    private WebElement serviceTypeDropdown;

    @FindBy(css = "#pay-section ul li:nth-child(1) p")
    private WebElement CommunicationServicesOption;

    @FindBy(xpath = "//label[@for='connection-phone']")
    private WebElement phoneLabel;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//label[@for='connection-sum']")
    private WebElement sumLabel;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailInput;

    public CommunicationServicesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectCommunicationServices() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommunicationServicesOption)).click();
    }

    public void checkPhoneField() {
        wait.until(ExpectedConditions.visibilityOf(phoneLabel));
        Assert.assertEquals(phoneLabel.getText(), "+375", "Надпись для кода страны неверна");
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Номер телефона", "Надпись для телефона неверна");
    }

    public void checkSumField() {
        wait.until(ExpectedConditions.visibilityOf(sumLabel));
        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        wait.until(ExpectedConditions.visibilityOf(sumInput));
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    public void checkEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }
}


class HomeInternetPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".select__header")
    private WebElement serviceTypeDropdown;

    @FindBy(css = "#pay-section ul li:nth-child(2) p")
    private WebElement homeInternetOption;

    @FindBy(xpath = "//*[@id=\"pay-internet\"]/div[1]/label")
    private WebElement phoneLabel;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"pay-internet\"]/div[2]/label")
    private WebElement sumLabel;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement emailInput;

    public HomeInternetPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void homeInternetService() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption)).click();
    }

    public void checkPhoneField() {
        wait.until(ExpectedConditions.visibilityOf(phoneLabel));
        Assert.assertEquals(phoneLabel.getText(), "+375", "Надпись для кода страны неверна");
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Номер абонента", "Надпись для телефона неверна");
    }

    public void checkSumField() {
        wait.until(ExpectedConditions.visibilityOf(sumLabel));
        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        wait.until(ExpectedConditions.visibilityOf(sumInput));
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    public void checkEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }
}

class InstallmentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".select__header")
    private WebElement serviceTypeDropdown;

    @FindBy(css = "#pay-section ul li:nth-child(3) p")
    private WebElement instalmentServicesOption;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement accountNumberInput;

    @FindBy(xpath = "//label[@for='instalment-sum']")
    private WebElement sumLabel;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement emailInput;


    public InstallmentPage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            PageFactory.initElements(driver, this);
        }

        public void installmentServicesService() {
            wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(instalmentServicesOption)).click();
        }

        public void checkAccountNumber() {
            wait.until(ExpectedConditions.visibilityOf(accountNumberInput));
            Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 44", "Надпись для номера счета неверна");
        }

    public void checkSumField() {
        wait.until(ExpectedConditions.visibilityOf(sumLabel));
        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        wait.until(ExpectedConditions.visibilityOf(sumInput));
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

        public void checkEmailField() {
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
        }
    }
class DebtPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".select__header")
    private WebElement serviceTypeDropdown;

    @FindBy(css = "#pay-section ul li:nth-child(4) p")
    private WebElement debtServicesOption;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement accountNumberInput;

    @FindBy(xpath = "//*[@id=\"pay-arrears\"]/div[2]/label")
    private WebElement sumLabel;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement emailInput;

    public DebtPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void DebtServicesService() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(debtServicesOption)).click();
    }

    public void checkAccountNumber() {
        wait.until(ExpectedConditions.visibilityOf(accountNumberInput));
        Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 2073", "Надпись для счета неверна");
    }

    public void checkSumField() {
        wait.until(ExpectedConditions.visibilityOf(sumLabel));
        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        wait.until(ExpectedConditions.visibilityOf(sumInput));
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    public void checkEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }
}

class OpenModalWindow {
    private WebDriver driver;
    private WebDriverWait wait;

    // Элементы страницы
    @FindBy(css = ".select__header")
    private WebElement serviceTypeDropdown;

    @FindBy(css = "#pay-section ul li:nth-child(1) p")
    private WebElement serviceOption;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
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

    public OpenModalWindow(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Открытие окна
    public void openModalWindow() {
        serviceTypeDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceOption)).click();
        phoneNumberInput.sendKeys("297777777");
        sumInput.sendKeys("100");
        continueButton.click();

        String expectedPhoneNumber = "375297777777";
        String expectedAmount = "100.00 BYN";
        verifyDisplayedInformation(expectedPhoneNumber, expectedAmount);
    }

    private void verifyDisplayedInformation(String expectedPhoneNumber, String expectedAmount) {
        verifyPhoneNumber(expectedPhoneNumber);
        verifyAmount(expectedAmount);
        verifyPaymentButton(expectedAmount);
        verifyCardInputLabels();
        verifyPaymentIcons();
    }

    private void switchToIframe() {
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Проверка номера телефона
    private void verifyPhoneNumber(String expectedPhoneNumber) {
        switchToIframe();
        WebElement displayedPhoneNumberElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span"))
        );

        String displayedText = displayedPhoneNumberElement.getText().trim();
        String actualPhoneNumber = displayedText.replaceAll(".*Номер:\\s*", "").trim();
        Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber, "Телефон отображается неверно");
        switchToDefaultContent();
    }

    // Проверка суммы
    private void verifyAmount(String expectedAmount) {
        switchToIframe();
        WebElement amountContainer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__cost']/span"))
        );
        String amountText = amountContainer.getText().trim();
        Assert.assertEquals(amountText, expectedAmount, "Сумма неверна");
        switchToDefaultContent();
    }

    // Проверка суммы на кнопке
    private void verifyPaymentButton(String expectedAmount) {
        switchToIframe();
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-page__card']/button")));
        String buttonText = payButton.getText().trim();
        Assert.assertTrue(buttonText.contains(expectedAmount), "Сумма на кнопке неверна");
        switchToDefaultContent();
    }

    // Проверка наличия надписей в полях для реквизитов карты
    private void verifyCardInputLabels() {
        switchToIframe();

        Assert.assertEquals(cardNumberLabel.getText().trim(), "Номер карты", "Надпись для номера карты неверна");
        Assert.assertEquals(expiryDateLabel.getText().trim(), "Срок действия", "Надпись для срока действия неверна");
        Assert.assertEquals(cvcLabel.getText().trim(), "CVC", "Надпись для CVC неверна");
        Assert.assertEquals(cardHolderNameLabel.getText().trim(), "Имя держателя (как на карте)", "Надпись для имени держателя карты неверна");

        switchToDefaultContent();
    }

    // Проверка наличия иконок платёжных систем
    private void verifyPaymentIcons() {
        switchToIframe();

        List<String> expectedIcons = Arrays.asList(
                "visa-system.svg",
                "mastercard-system.svg",
                "belkart-system.svg",
                "maestro-system.svg",
                "mir-system-ru.svg"
        );

        Assert.assertFalse(paymentIcons.isEmpty(), "Иконки платёжной системы не отображаются");

        // Проверка наличия каждой иконки
        for (String expectedIcon : expectedIcons) {
            boolean iconFound = paymentIcons.stream()
                    .anyMatch(icon -> icon.getAttribute("src").endsWith(expectedIcon));
            Assert.assertTrue(iconFound, "Иконка " + expectedIcon + " отсутствует на странице");
        }

        // Проверка иконок Maestro и Mir, которые могут сменять друг друга
        boolean maestroDisplayed = isElementPresent(By.xpath("//img[contains(@src, 'maestro-system.svg')]"));
        boolean mirDisplayed = isElementPresent(By.xpath("//img[contains(@src, 'mir-system-ru.svg')]"));

        Assert.assertTrue(maestroDisplayed || mirDisplayed, "Не отображаются ни иконки Maestro, ни Mir");

        switchToDefaultContent();
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

