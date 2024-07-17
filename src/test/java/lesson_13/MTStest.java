package lesson_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class MTStest {
    private WebDriver driver;

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        WebElement click = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        click.click();
    }

    @Test
    public void testBlockName() {
        WebElement blockName = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));
        Assert.assertEquals(blockName.getText(), "Онлайн пополнение\nбез комиссии");
    }

    @Test
    public void testlogoPay() {
        List<WebElement> testLogoPay = driver.findElements(By.xpath("//div[@class='pay__partners']//ul"));
        Assert.assertFalse(testLogoPay.isEmpty());
    }

    @Test
    public void testLink() {
        WebElement linkInfo = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));
        linkInfo.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
        driver.navigate().back();

    }

    @Test
    public void continueButton(){
        WebElement inputPhone = driver.findElement(By.xpath("//input[@placeholder=\"Номер телефона\"]"));
        WebElement inputMoney = driver.findElement(By.xpath("//input[@placeholder=\"Сумма\"]"));
        WebElement inputMail = driver.findElement(By.xpath("//input[@placeholder=\"E-mail для отправки чека\"]"));
        WebElement button = driver.findElement(By.xpath("//button[@class =\"button button__default \"]"));
        inputPhone.sendKeys("297777777");
        inputMoney.sendKeys("300");
        inputMail.sendKeys("anton@gmail.ru");
        button.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.mts.by/");
    }



}


