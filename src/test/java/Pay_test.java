import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Pay_test {
    WebDriver driver;
    By phoneNumber = By.xpath("//input[@placeholder=\"Номер телефона\"]");//Номер телефона
    By summ = By.xpath("//input[@placeholder=\"Сумма\"]"); // Сумма
    By Mail = By.xpath("//input[@placeholder=\"E-mail для отправки чека\"]"); // Почта для отправки чека
    By Frame = By.xpath("//*[@id=\"cookie-agree\"]");
    By Button = By.xpath("//button[@class =\"button button__default \"]");
    By FramePay = By.xpath("//iframe[@class=\"bepaid-iframe\"]");
    By Pay300 = By.xpath("//div[@class = \"pay-description__cost\"]//span[contains(text(),\"BYN\")]");
    By ButtomPay300 = By.xpath("//button[@class=\"colored disabled\"]");
    By CommunicationServicesNumber = By.xpath("//div[@class=\"pay-description__text\"]");
    By PaymentCardNumber = By.xpath("//label[@class=\"ng-tns-c46-1 ng-star-inserted\"]");
    By CardExpiryDate = By.xpath("//label[@class=\"ng-tns-c46-4 ng-star-inserted\"]");
    By CardholderName = By.xpath("//label[@class=\"ng-tns-c46-3 ng-star-inserted\"]");
    By MasterCard = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][1]");
    By Visa = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][2]");
    By Belcard = By.xpath("//img[@class=\"ng-tns-c61-0 ng-star-inserted\"][3]");

    By Mir = By.xpath("//img[@class=\"ng-tns-c61-0 ng-trigger ng-trigger-randomCardState ng-star-inserted\"]");
    public static final String Master ="https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg";
    public static final String Visa = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg";
    public static final String Belcard = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg";
    public static final String Mir = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg";
    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        WebElement click = driver.findElement(Frame);
        click.click();
    }

    @Test(priority = 1)
    public void continueButton() {
        WebElement inputPhone = driver.findElement(phoneNumber);
        WebElement inputMoney = driver.findElement(summ);
        WebElement inputMail = driver.findElement(Mail);
        WebElement button = driver.findElement(Button);
        inputPhone.sendKeys("297777777");
        inputMoney.sendKeys("300");
        inputMail.sendKeys("anton@gmail.ru");
        button.click();


    }

    @Test(priority = 2)


    public void paydescription() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(FramePay));
    }

    @Test(priority = 3)
    public void paydescription2() {
        WebElement pay = driver.findElement(Pay300);
        Assert.assertEquals(pay.getText(), "300.00 BYN");
    }

    @Test(priority = 4)
    public void button() {
        WebElement button = driver.findElement(ButtomPay300);
        Assert.assertEquals(button.getText(), "Оплатить 300.00 BYN");
    }

    @Test(priority = 5)
    public void numberphone() {

        WebElement tellNumber = driver.findElement(CommunicationServicesNumber);
        Assert.assertEquals(tellNumber.getText(), "Оплата: Услуги связи Номер:375297777777");
    }

    @Test(priority = 6)
    public void cardnumb() {

        WebElement numbCard = driver.findElement(PaymentCardNumber);
        Assert.assertEquals(numbCard.getText(), "Номер карты");
    }

    @Test(priority = 7)
    public void validityCard() {

        WebElement validity = driver.findElement(CardExpiryDate);
        Assert.assertEquals(validity.getText(), "Срок действия");
    }

    @Test(priority = 8)
    public void holderName() {
        WebElement name = driver.findElement(CardholderName);
        Assert.assertEquals(name.getText(), "Имя держателя (как на карте)");
    }

    @Test(priority = 9)
    public void logoCard() {
        WebElement logo = driver.findElement(MasterCard);
        Assert.assertEquals(logo.getAttribute("src"), Master);
    }

    @Test(priority = 10)
    public void logoCard2() {
        WebElement logo2 = driver.findElement(Visa);
        Assert.assertEquals(logo2.getAttribute("src"), Visa);

    }

    @Test(priority = 11)
    public void logoCard3() {
        WebElement logo3 = driver.findElement(Belcard);
        Assert.assertEquals(logo3.getAttribute("src"), Belcard);

    }
    @Test(priority = 12)
    public void logoCard4(){
        WebElement logo4 = driver.findElement(Mir);
        Assert.assertEquals(logo4.getAttribute("src"),Mir);
    }


}



