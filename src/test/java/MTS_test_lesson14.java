import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MTS_test_lesson14 {

    WebDriver driver;
    By accordion = By.xpath("//span[@class=\"select__arrow\"]");// Меню аккордион
    By communicationServices = By.xpath("//ul[@class=\"select__list\"]//li[1]");// Услуги связи
    By homeInternet = By.xpath("//ul[@class=\"select__list\"]//li[2]");// Домашний интернет
    By installmentPlan = By.xpath("//ul[@class=\"select__list\"]//li[3]"); //Рассрочка
    By debt = By.xpath("//ul[@class=\"select__list\"]//li[4]"); // Задолженность
    By subNumber = By.xpath("//input[@placeholder=\"Номер абонента\"]");//Номер абонента
    By phoneNumber = By.xpath("//input[@placeholder=\"Номер телефона\"]");//Номер телефона
    By summ = By.xpath("//input[@placeholder=\"Сумма\"]"); // Сумма
    By Mail = By.xpath("//input[@placeholder=\"E-mail для отправки чека\"]"); // Почта для отправки чека
    By accountNumberFor44 = By.xpath("//input[@placeholder=\"Номер счета на 44\"]"); // Номер счета 44
    By accountNumberFor2073 = By.xpath("//input[@placeholder=\"Номер счета на 2073\"]"); // Номер счета на 2073

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        WebElement click = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        click.click();
    }


    @Test(priority = 4)
    public void testcommunicationServices() {
        WebElement ckick = driver.findElement(accordion);
        WebElement click2 = driver.findElement(communicationServices);


        Actions actions = new Actions(driver);
        actions.moveToElement(ckick).click().moveToElement(click2).click().release().build().perform();

        WebElement subscriberNumber = driver.findElement(phoneNumber);
        Assert.assertEquals(subscriberNumber.getAttribute("placeholder"), "Номер телефона");

        WebElement amountOfmoney = driver.findElement(summ);
        Assert.assertEquals(amountOfmoney.getAttribute("placeholder"), "Сумма");

        WebElement eMail = driver.findElement(Mail);
        Assert.assertEquals(eMail.getAttribute("placeholder"), "E-mail для отправки чека");

    }


    @Test(priority = 1)
    public void testHomeInternet() {

        WebElement ckick = driver.findElement(accordion);
        WebElement click2 = driver.findElement(homeInternet);


        Actions actions = new Actions(driver);
        actions.moveToElement(ckick).click().moveToElement(click2).click().release().build().perform();

        WebElement subscriberNumber = driver.findElement(subNumber);
        Assert.assertEquals(subscriberNumber.getAttribute("placeholder"), "Номер абонента");

        WebElement amountOfmoney = driver.findElement(summ);
        Assert.assertEquals(amountOfmoney.getAttribute("placeholder"), "Сумма");

        WebElement eMail = driver.findElement(Mail);
        Assert.assertEquals(eMail.getAttribute("placeholder"), "E-mail для отправки чека");

    }

    @Test(priority = 2)
    public void installmentPlan() {

        WebElement click = driver.findElement(accordion);
        WebElement click2 = driver.findElement(installmentPlan);

        Actions actions = new Actions(driver);
        actions.moveToElement(click).click().moveToElement(click2).click().release().build().perform();

        WebElement subscriberNumber = driver.findElement(accountNumberFor44);
        Assert.assertEquals(subscriberNumber.getAttribute("placeholder"), "Номер счета на 44");

        WebElement amountOfmoney = driver.findElement(summ);
        Assert.assertEquals(amountOfmoney.getAttribute("placeholder"), "Сумма");

        WebElement eMail = driver.findElement(Mail);
        Assert.assertEquals(eMail.getAttribute("placeholder"), "E-mail для отправки чека");

    }

    @Test(priority = 3)

    public void debt() {


        WebElement ckick = driver.findElement(accordion);
        WebElement click2 = driver.findElement(debt);

        Actions actions = new Actions(driver);
        actions.moveToElement(ckick).click().moveToElement(click2).click().release().build().perform();

        WebElement subscriberNumber = driver.findElement(accountNumberFor2073);
        Assert.assertEquals(subscriberNumber.getAttribute("placeholder"), "Номер счета на 2073");

        WebElement amountOfmoney = driver.findElement(summ);
        Assert.assertEquals(amountOfmoney.getAttribute("placeholder"), "Сумма");

        WebElement eMail = driver.findElement(Mail);
        Assert.assertEquals(eMail.getAttribute("placeholder"), "E-mail для отправки чека");

    }




}

