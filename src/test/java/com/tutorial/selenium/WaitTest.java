package com.tutorial.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public  static void tearDown(){
        driver.quit();

    }

    @Test
    public  void testImplicitWait(){
        driver.get("http://www.google.com");
        //ojidanie maximum 5 sek. esli nashel rashel - idet dalishe
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        WebElement element =driver.findElement(By.name("qhujo"));
    }

    @Test
    public  void testExplicitWait(){
        driver.get("http://www.google.com");
        //sozdaem obiekt tipa WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q")));
    }

    @Test
    public void testFluentWait(){
        driver.get("http://www.google.com");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                //cerez kakoe vremea sovershaem zapros:
                .pollingEvery(Duration.ofMillis(600))
                //kakuiu oshibku ignoriruem:
                .ignoring(NoSuchElementException.class);
        WebElement element =wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.name("q"));
            }
        });
    }
}

