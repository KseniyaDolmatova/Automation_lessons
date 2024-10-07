import org.openqa.selenium.*;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

    @Test (priority = 1)
    public void testFieldLabelsInCommunicationServices() {
        // Выбор типа сервиса "Услуги связи"
        selectServiceInCommunicationServices("Услуги связи");

        // Проверка полей
        checkPhoneFieldInCommunicationServices(); // Телефон
        checkSumFieldInCommunicationServices(); // Сумма
        checkEmailFieldInCommunicationServices(); // Email
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

    @Test (priority = 2)
    public void testFieldLabelsInHomeInternet() {
        // Выбор типа сервиса "Домашний интернет"
        selectServiceInHomeInternet("Домашний интернет");

        // Проверка полей
        checkPhoneFieldInHomeInternet(); // Телефон
        checkSumFieldInHomeInternet(); // Сумма
        checkEmailFieldInHomeInternet(); // Email
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

    @Test (priority = 3)
    public void testFieldLabelsInInstallmentServices() {
        // Выбор типа сервиса "Рассрочка"
        selectServiceInInstallmentServices("Рассрочка");

        // Проверка полей
        checkAccountNumberFieldInInstallmentServices(); // Номерр счета
        checkInstalmentSumFieldInInstallmentServices(); // Сумма
        checkEmailFieldInInstallmentServices(); // Email
    }

    private void selectServiceInInstallmentServices(String serviceName) {
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"))); // Выбираем "Рассрочка"
        serviceOption.click();
    }

    private void checkAccountNumberFieldInInstallmentServices() {
        WebElement accountNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-instalment']")));

        Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 44", "Надпись для номера счета неверна");
    }

    private void checkInstalmentSumFieldInInstallmentServices() {
        WebElement instalmentSumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-sum']"))); // Поле суммы рассрочки
        WebElement instalmentSumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='instalment-sum']")));

        Assert.assertEquals(instalmentSumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(instalmentSumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    private void checkEmailFieldInInstallmentServices() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='instalment-email']")));

        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test (priority = 4)
    public void testFieldLabelsInDebtServices() {
        // Выбор типа сервиса "Задолженность"
        selectServiceInDebtServices("Задолженность");

        // Проверка полей
        checkAccountNumberFieldInDebtServices(); // Номер счета
        checkDebtSumFieldInDebtServices(); // Сумма задолжденности
        checkEmailFieldInDebtServices(); // Email
    }

    private void selectServiceInDebtServices(String serviceName) {

        WebElement clickableElement = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        clickableElement.click();
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        // Выбираем "Задолженность"
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")));
        serviceOption.click();
    }

    private void checkAccountNumberFieldInDebtServices() {
        WebElement accountNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='score-arrears']")));
        Assert.assertEquals(accountNumberInput.getAttribute("placeholder"), "Номер счета на 2073", "Надпись для номера счета неверна");
    }

    private void checkDebtSumFieldInDebtServices() {
        WebElement debtSumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-sum']")));
        WebElement debtSumLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-arrears\"]/div[2]/label")));

        Assert.assertEquals(debtSumLabel.getText(), "Руб.", "Надпись для валюты неверна");
        Assert.assertEquals(debtSumInput.getAttribute("placeholder"), "Сумма", "Надпись для суммы неверна");
    }

    private void checkEmailFieldInDebtServices() {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='arrears-email']")));
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "E-mail для отправки чека", "Надпись для email неверна");
    }

    @Test (priority = 5)
    public void openModalWindow() {

        WebElement clickableElement = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        clickableElement.click();
        // Заполнение формы
        WebElement serviceTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        serviceTypeDropdown.click();

        // Выбираем «Услуги связи»
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")));
        serviceOption.click();

        // Заполняем телефон
        WebElement phoneNumberInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumberInput.sendKeys("297777777");

        // Заполняем сумму
        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("100");

        // Нажимаем на кнопку
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        // Инициируем переменные
        String expectedPhoneNumber = "375297777777"; // Объявление переменной
        String expectedAmount = "100.00 BYN"; // Объявление переменной

        // Вызов метода
        verifyDisplayedInformation(expectedPhoneNumber, expectedAmount);
    }

    private void verifyDisplayedInformation(String expectedPhoneNumber, String expectedAmount) {
        verifyPhoneNumber(expectedPhoneNumber);
        verifyAmount(expectedAmount);
        verifyPaymentButton(expectedAmount);
        verifyCardInputLabels();
        verifyPaymentIcons();
    }

    // Фрейм
    private void switchToIframe() {
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

        // Проверка отображения номера телефона
        private void verifyPhoneNumber(String expectedPhoneNumber) {

            switchToIframe();

            // Находим элемент с номером телефона
            WebElement displayedPhoneNumberElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span"))
            );

            String displayedText = displayedPhoneNumberElement.getText().trim(); // Убираем лишние пробелы

            // Извлекаем номер телефона из текста, удаляя лишние слова
            String actualPhoneNumber = displayedText.replaceAll(".*Номер:\\s*", "").trim();

            // Сравниваем текст на странице с ожидаемым значением
            Assert.assertEquals(expectedPhoneNumber, actualPhoneNumber, "Телефон отображается неверно");

            switchToDefaultContent();
        }

        // Проверка суммы
        private void verifyAmount(String expectedAmount) {

            switchToIframe();

            WebElement amountContainer = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'pay-description__cost')]/span"))
            );
            String amountText = amountContainer.getText().trim(); // Убираем лишние пробелы

            // Сравниваем текст на странице с ожидаемым значением
            Assert.assertEquals(amountText, expectedAmount, "Сумма неверна");

            switchToDefaultContent();
        }

        // Проверка суммы на кнопке
    private void verifyPaymentButton(String expectedAmount) {

        switchToIframe();

        // Ожидание и получение элемента кнопки
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'colored') and contains(text(), 'Оплатить')]")));

        // Получение текста кнопки и удаление лишних пробелов
        String buttonText = payButton.getText().trim(); // Убираем лишние пробелы

        // Проверяем, совпадает ли показанный текст с ожидаемым
        Assert.assertTrue(buttonText.contains(expectedAmount), "Сумма на кнопке неверна");

        switchToDefaultContent();
    }

        // Проверка наличия надписей в полях для реквизитов карты
        private void verifyCardInputLabels() {

            switchToIframe();

            // Проверка надписи для номера карты
            Assert.assertEquals(getLabelText("//label[contains(text(), 'Номер карты')]"), "Номер карты", "Надпись для номера карты неверна");

            // Проверка надписи для срока действия
            Assert.assertEquals(getLabelText("//label[contains(text(), 'Срок действия')]"), "Срок действия", "Надпись для срока действия неверна");

            // Проверка надписи для CVC
            Assert.assertEquals(getLabelText("//label[contains(text(), 'CVC')]"), "CVC", "Надпись для CVC неверна");

            // Проверка надписи для имени держателя карты
            Assert.assertEquals(getLabelText("//label[contains(text(), 'Имя держателя (как на карте)')]"), "Имя держателя (как на карте)", "Надпись для имени держателя карты неверна");

            switchToDefaultContent();
        }

        // Вспомогательный метод для получения текста метки
        private String getLabelText(String xpath) {
            WebElement labelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return labelElement.getText().trim(); // Убираем лишние пробелы
        }

        // Проверка наличия иконок платёжных систем
        private void verifyPaymentIcons() {

            switchToIframe();

            // Ожидаемые иконки
            List<String> expectedIcons = Arrays.asList(
                    "visa-system.svg",
                    "mastercard-system.svg",
                    "belkart-system.svg",
                    "maestro-system.svg",
                    "mir-system-ru.svg"
            );

            // Получение всех иконок на странице
            List<WebElement> paymentIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'cards-brands cards-brands__container')]//img"))
            );

            Assert.assertFalse(paymentIcons.isEmpty(), "Иконки платёжной системы не отображаются");

            // Проверка наличия каждой иконки
            for (String expectedIcon : expectedIcons) {
                boolean iconFound = paymentIcons.stream()
                        .anyMatch(icon -> icon.getAttribute("src").endsWith(expectedIcon));

                Assert.assertTrue(iconFound, "Иконка " + expectedIcon + " отсутствует на странице");
            }

            // Проверка иконок Maestro и Mir, которые могут сменять друг друга
            boolean maestroDisplayed = isElementPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]"));
            boolean mirDisplayed = isElementPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]"));

            // Тест пройдет, если хотя бы одна из иконок Maestro или Mir отображается
            Assert.assertTrue(maestroDisplayed || mirDisplayed, "Не отображаются ни иконки Maestro, ни Mir");

            switchToDefaultContent();
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
