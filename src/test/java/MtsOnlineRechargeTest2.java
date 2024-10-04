import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
import java.util.Arrays;
import java.util.List;

public class MtsOnlineRechargeTest2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
    public void testFieldLabelsInCommunicationServices() {
        // Выбор типа сервиса "Услуги связи"
        selectServiceInCommunicationServices("Услуги связи");

        // Проверка полей
        checkPhoneFieldInCommunicationServices();
        checkSumFieldInCommunicationServices();
        checkEmailFieldInCommunicationServices();
    }

    private void selectServiceInCommunicationServices(String serviceName) {
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"))); // Выбираем "Услуги связи"
        serviceOption.click();
    }

    // Проверка полей для телефона
    private void checkPhoneFieldInCommunicationServices() {
        WebElement phoneLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='connection-phone']")));
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));

        Assert.assertEquals(phoneLabel.getText(), "+375", "Надпись для кода страны неверна");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Номер телефона", "Надпись для телефона неверна");
    }

    // Проверка полей для суммы
    private void checkSumFieldInCommunicationServices() {
        WebElement sumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='connection-sum']")));
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-sum']")));

        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    // Проверка полей для email
    private void checkEmailFieldInCommunicationServices() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-email']")));

        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test
    public void testFieldLabelsInHomeInternet() {
        // Выбор типа сервиса "Домашний интернет"
        selectServiceInHomeInternet("Домашний интернет");

        // Проверка полей
        checkPhoneFieldInHomeInternet();
        checkSumFieldInHomeInternet();
        checkEmailFieldInHomeInternet();
    }

    private void selectServiceInHomeInternet(String serviceName) {
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + serviceName + "']")));
        serviceOption.click();
    }

    private void checkPhoneFieldInHomeInternet() {
        WebElement phoneLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='internet-phone']")));
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-phone']")));

        Assert.assertEquals(phoneLabel.getText(), "+375", "Надпись для кода страны неверна");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Номер абонента", "Надпись для телефона неверна");
    }

    private void checkSumFieldInHomeInternet() {
        WebElement sumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='internet-sum']")));
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-sum']")));

        Assert.assertEquals(sumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(sumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    private void checkEmailFieldInHomeInternet() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='internet-email']")));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test
    public void testFieldLabelsInInstallmentServices() {
        // Выбор типа сервиса "Рассрочка"
        selectServiceInInstallmentServices("Рассрочка");

        // Проверка полей
        checkAccountNumberFieldInInstallmentServices(); // Проверка поля для номера счета
        checkInstalmentSumFieldInInstallmentServices(); // Проверка поля для суммы
        checkEmailFieldInInstallmentServices(); // Проверка поля для email
    }

    private void selectServiceInInstallmentServices(String serviceName) {
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"))); // Выбираем "Рассрочка"
        serviceOption.click();
    }

    // Проверка поля для номера счета
    private void checkAccountNumberFieldInInstallmentServices() {
        WebElement accountNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-instalment']")));

        Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 44", "Надпись для номера счета неверна");
    }

    // Проверка поля для суммы рассрочки
    private void checkInstalmentSumFieldInInstallmentServices() {
        WebElement instalmentSumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-sum']"))); // Поле суммы рассрочки
        WebElement instalmentSumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='instalment-sum']")));

        Assert.assertEquals(instalmentSumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(instalmentSumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    // Проверка полей для email
    private void checkEmailFieldInInstallmentServices() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-email']")));

        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test
    public void testFieldLabelsInDebtServices() {
        // Выбор типа сервиса "Задолженность"
        selectServiceInDebtServices("Задолженность");

        // Проверка полей
        checkAccountNumberFieldInDebtServices(); // Проверка поля для номера счета
        checkDebtSumFieldInDebtServices(); // Проверка поля для суммы задолженности
        checkEmailFieldInDebtServices(); // Проверка поля для email
    }

    private void selectServiceInDebtServices(String serviceName) {
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        // Выбираем "Задолженность"
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")));
        serviceOption.click();
    }

    // Проверка поля для номера счета
    private void checkAccountNumberFieldInDebtServices() {
        WebElement accountNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-arrears']")));
        Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 2073", "Надпись для номера счета неверна");
    }

    // Проверка поля для суммы задолженности
    private void checkDebtSumFieldInDebtServices() {
        WebElement debtSumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-sum']")));
        WebElement debtSumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-arrears\"]/div[2]/label")));

        Assert.assertEquals(debtSumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(debtSumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    // Проверка поля для email
    private void checkEmailFieldInDebtServices() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-email']")));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test
    public void testFieldLabelsInModalWindow() {
        // Инициируем переменные
        String expectedPhoneNumber = "297777777"; // Объявление переменной
        String expectedAmount = "100"; // Объявление переменной

        // Выбор типа сервиса "Услуги связи"
        selectServiceInCommunicationServices("Услуги связи");

        // Заполняем телефон
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberInput.sendKeys(expectedPhoneNumber);

        // Заполняем сумму
        WebElement sum = driver.findElement(By.cssSelector("#connection-sum"));
        sum.sendKeys(expectedAmount);

        // Нажимаем на кнопку
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        // Вызов метода
        verifyDisplayedInformation(expectedPhoneNumber, expectedAmount);
    }

    private void verifyDisplayedInformation(String expectedPhoneNumber, String expectedAmount) {
        //verifyPhoneNumber(expectedPhoneNumber);
        verifyAmount(expectedAmount);
        verifyPaymentButton(expectedAmount);
        verifyCardInputLabels();
        verifyPaymentIcons();
    }

        // Проверка отображения номера телефона
        //private void verifyPhoneNumber (String expectedPhoneNumber){
           // WebElement displayedCountryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'pay-description__text')]/span")));
          //  String displayedText = displayedCountryCode.getText();

          //  String expectedCountryCode = "+375"; // Ожидаемый код страны
           // Assert.assertTrue(displayedText.startsWith(expectedCountryCode), "Код страны отображается неверно");

           // String phoneWithoutCode = expectedPhoneNumber.replaceFirst("\\+375", ""); // Удаляем код страны для сравнения
          //  Assert.assertTrue(displayedText.contains(phoneWithoutCode), "Номер телефона отображается неверно");
      //  }

        // Проверка суммы и валюты
        private void verifyAmount (String expectedAmount){
            WebElement amountContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Руб.')]")));
            String amountText = amountContainer.getText();
            Assert.assertTrue(amountText.contains(expectedAmount), "Сумма неверна");

            String expectedCurrency = "Руб."; // Ожидаемая валюта для проверки
            Assert.assertTrue(amountText.contains(expectedCurrency), "Валюта неверна");
        }

        // Проверка суммы и валюты на кнопке
        private void verifyPaymentButton (String expectedAmount){
            WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оплатить')]")));
            String buttonText = payButton.getText();
            String[] buttonParts = buttonText.split(" "); // Разделяем текст кнопки на части
            Assert.assertEquals(buttonParts[1], expectedAmount, "Сумма на кнопке неверна");
            Assert.assertEquals(buttonParts[2], "Руб.", "Валюта на кнопке неверна");
        }

        // Проверка наличия надписей в полях для реквизитов карты
        private void verifyCardInputLabels () {
            Assert.assertEquals(getLabelText("//label[@for='cc-number']"), "Номер карты", "Надпись для номера карты неверна");
            Assert.assertEquals(getLabelText("//label[contains(text(), 'Срок действия')]"), "Срок действия", "Надпись для срока действия неверна");
            Assert.assertEquals(getLabelText("//label[contains(text(), 'CVC')]"), "CVC", "Надпись для CVC неверна");
            Assert.assertEquals(getLabelText("//label[contains(text(), 'Имя держателя (как на карте)')]"), "Имя держателя (как на карте)", "Надпись для имени держателя карты неверна");
        }

        // Вспомогательный метод для получения текста метки
        private String getLabelText (String xpath){
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return label.getText();
        }

        // Проверка наличия иконок платёжных систем
        private void verifyPaymentIcons () {
            // Ожидаемые иконки
            List<String> expectedIcons = Arrays.asList("visa-system.svg", "mastercard-system.svg", "belkart-system.svg", "maestro-system.svg", "mir-system-ru.svg");

            // Получение всех иконок на странице
            List<WebElement> paymentIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'cards-brands__container')]//img")));

            Assert.assertFalse(paymentIcons.isEmpty(), "Иконки платёжной системы не отображаются");

            // Проверка наличия каждой иконки
            for (String expectedIcon : expectedIcons) {
                boolean iconFound = paymentIcons.stream()
                        .anyMatch(icon -> icon.getAttribute("src").contains(expectedIcon));
                Assert.assertTrue(iconFound, "Иконка " + expectedIcon + " отсутствует на странице");
            }

            // Проверка иконок Maestro и Mir, которые могут сменять друг друга
            boolean maestroDisplayed = isElementPresent(By.xpath("//div[contains(@class, 'cards-brands_random')]//img[contains(@src, 'maestro-system.svg') and not(contains(@style, 'opacity: 0'))]"));
            boolean mirDisplayed = isElementPresent(By.xpath("//div[contains(@class, 'cards-brands_random')]//img[contains(@src, 'mir-system-ru.svg') and not(contains(@style, 'opacity: 0'))]"));

            Assert.assertTrue(maestroDisplayed || mirDisplayed, "Иконки Maestro и Mir не отображаются");
        }

        private boolean isElementPresent (By by){
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }


        @AfterClass
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
    }
