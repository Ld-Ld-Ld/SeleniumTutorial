package com.tutorial.selenium;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("setting web driver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://999.md/ru");

    }

    @AfterClass

    public static void tearDown() {
        System.out.println("closing the driver");
        driver.quit();
    }

    @Test
    public void makeScreenshot() {
        //obiavleaem klass TakesScreenshot. kastim driver, privodim k tipu TakesScreenshot:
        TakesScreenshot camera = (TakesScreenshot) driver;
        //ctobi sohraniti screenshot, nado sozdato obiekt klassa File
        // i s pomoshiu obiekta camera sohraniti screenshot:
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            File destinationFile = new File("src/main/resources/screenshot.png");
            FileUtils.copyFile(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
