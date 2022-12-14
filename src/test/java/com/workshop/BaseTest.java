package com.workshop;

import net.bytebuddy.asm.Advice;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    private static WebDriver driver;
    private final static String URL = "https://smadshop.md/";

    @BeforeClass
    public static void setUp(){
        System.out.println("Setting webdriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Closing the driver");
        driver.quit();
    }

    //getter dlea driver. t.k. on u nas private, nam nujen metod po ego izvleceniu
    public static WebDriver getDriver(){
        return driver;
    }
}
