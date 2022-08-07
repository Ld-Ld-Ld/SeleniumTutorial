package com.tutorial.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AlertInteraction {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        List< WebElement> buttons = driver.findElements(By.tagName("button"));

        //eto kollektzia, poetomu deistvuet metod size()
        //mi udostovereamsea, esli u vse 3 knopki na meste, to mi hotim kliknuti po poslednei is nih:
        if(buttons.size() == 3) {
            buttons.get(2).click();
            }

        //esti klass allert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        Thread.sleep(3000);
        //nabiraem text vo svplivaushem okne:
        alert.sendKeys("hello there!");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);

        driver.quit();

    }
}
