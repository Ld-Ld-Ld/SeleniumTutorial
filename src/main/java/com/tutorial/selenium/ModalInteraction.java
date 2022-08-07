package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalInteraction {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");

        //sozdaem obiekt tipa string.
        // get current window handle(kak zakladka na tekushee okno)
        // currentWindow iznacalinaia stranitza:
        String currentWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector("button[data-toggle='modal']")).click();

        WebElement modal = driver.findElement(By.className("modal-body"));

        //smotrim sk u nas voobshe raznih stranitz predstavleno
        for (String windowName : driver.getWindowHandles()) {
            //esli tekushee imea stranitzi = iznacalinoi, to mi ni4ego ne delaem
            //esli ne ravno, to mi perekliucaemsea
            if (!windowName.equals(currentWindow)) {
                driver.switchTo().window(windowName);
                break;
            }
        }

        Thread.sleep(3000);
        modal.findElement(By.xpath("//*[@class='btn btn-default']")).click();

        Thread.sleep(3000);

        driver.switchTo().window(currentWindow);
        driver.quit();
    }
}
