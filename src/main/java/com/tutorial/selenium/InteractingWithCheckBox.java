package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractingWithCheckBox {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        Thread.sleep(5000);
        driver.findElements(By.tagName("input")).get(0).click();
        Thread.sleep(5000);
        driver.findElements(By.tagName("input")).get(1).click();
        Thread.sleep(5000);

        driver.quit();

    }
}
