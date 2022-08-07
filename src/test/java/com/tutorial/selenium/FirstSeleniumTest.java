package com.tutorial.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //initialize webdriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown() {
        //close all tabs
        driver.quit();

    }

    @Test
    public void testASearch() {
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Kindle");
        searchInput.submit();
        //eto soobshenie vilezet, esle test upadet. Test:Slovo Kindle doljno biti v linke:
        assertTrue("The url doesn't contain the expected term", driver.getCurrentUrl().contains("Kindle"));
    }

    @Test
    public void testBFilters() {
        WebElement priceFrom = driver.findElement(By.id("low-price"));
        //vbivaem tzenu minimalinuu:
        priceFrom.sendKeys("150");
        //enter:
        priceFrom.submit();

        List<WebElement> prices = driver.findElements(By.className(".a-price-whole"));

        //for-each: otdelinii price iz vseh prices:
        for (WebElement price : prices) {
            //polucaem text elementa(price stringovii), parsim ego dlea prevedenia k tzelocislennomu znaceniu i sravnivaem so 150:
            assertTrue(Integer.parseInt(price.getText()) >= 150);
        }
    }
    }
