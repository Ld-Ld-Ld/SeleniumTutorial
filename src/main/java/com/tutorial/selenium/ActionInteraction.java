package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionInteraction {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> avatars = driver.findElements(By.className("figure"));

        //sozdaem obiekt klassa Actions:
        Actions action = new Actions(driver);
        //navodim mish na element pod indexom 1(t.e. esti index 0, a eto vtoroi):
        action.moveToElement(avatars.get(1)).perform();

        Thread.sleep(3000);

        //ctobi poneati, cto eto navedenie mishiu slucilosi i test proshel, nam nado pereiti po linke.
        //poetomu sozdaem
        driver.findElement(By.linkText("View profile")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
